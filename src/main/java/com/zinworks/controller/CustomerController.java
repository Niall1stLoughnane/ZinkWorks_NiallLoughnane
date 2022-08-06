package com.zinworks.controller;

import com.zinworks.exceptions.*;
import com.zinworks.model.Balance;
import com.zinworks.model.DispensedAmount;
import com.zinworks.service.BalanceService;
import com.zinworks.service.CustomerService;
import com.zinworks.service.DispenseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.zip.ZipException;

@RequestMapping("/customer")
@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private BalanceService balanceService;

    @Autowired
    private DispenseServiceImpl dispenseService;

    @GetMapping("/balance")
    Balance getBalance(@RequestParam(name = "accountNumber") Integer accountNumber, @RequestParam(name = "pin") Integer pin) throws CustomerInvalidException {
        this.customerService.isValidCustomer(accountNumber, pin);
        return balanceService.getBalanceDetails(accountNumber, pin);
    }

    @DeleteMapping("/dispenseAccount")
    DispensedAmount dispenseAccount(@RequestParam(name = "accountNumber") Integer accountNumber, @RequestParam(name = "pin") Integer pin, @RequestParam(name = "amountRequested") double amountRequested) throws ZinWorksExeption {
        this.customerService.isValidCustomer(accountNumber, pin);
        return dispenseService.dispense(accountNumber, pin, amountRequested);
    }

}
