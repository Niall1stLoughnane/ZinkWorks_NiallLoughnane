package com.zinkworks.controller;

import com.zinkworks.enums.RequestType;
import com.zinkworks.exceptions.*;
import com.zinkworks.model.Balance;
import com.zinkworks.model.DispensedAmount;
import com.zinkworks.service.BalanceService;
import com.zinkworks.service.CustomerService;
import com.zinkworks.service.DispenseServiceImpl;
import com.zinkworks.service.StatisticsService;
import com.zinkworks.utils.LoggingUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/customer")
@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private BalanceService balanceService;

    @Autowired
    private DispenseServiceImpl dispenseService;

    @Autowired
    private StatisticsService statisticsService;

    @GetMapping("/balance")
    Balance getBalance(@RequestParam(name = "accountNumber") Integer accountNumber, @RequestParam(name = "pin") Integer pin) throws CustomerInvalidException, AccountNotValidatedException {
        statisticsService.addBalanceRequest();
        LoggingUtils.logMessage("INFO", this.getClass().getSimpleName(), Integer.toString(accountNumber), "Getting Balance");
        this.customerService.isValidCustomer(accountNumber, pin, RequestType.Balance);
        return balanceService.getBalanceDetails(accountNumber, pin);
    }

    @DeleteMapping("/dispenseAccount")
    DispensedAmount dispenseAccount(@RequestParam(name = "accountNumber") Integer accountNumber, @RequestParam(name = "pin") Integer pin, @RequestParam(name = "amountRequested") double amountRequested) throws ZinWorksException {
        statisticsService.addWithdrawal(amountRequested);
        LoggingUtils.logMessage("INFO", this.getClass().getSimpleName(), Integer.toString(accountNumber), "Dispensing from customer");
        this.customerService.isValidCustomer(accountNumber, pin, RequestType.Withdrawal);
        try{
            DispensedAmount dispensedAmount = dispenseService.dispense(accountNumber, pin, amountRequested);
            this.statisticsService.addWithdrawalSuccessful(amountRequested);
            return dispensedAmount;
        } catch (ZinWorksException e) {
            this.statisticsService.addWithdrawalFailure(amountRequested);
            throw e;
        }
    }

}
