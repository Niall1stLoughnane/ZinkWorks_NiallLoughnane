package com.zinkworks.service;

import com.zinkworks.exceptions.*;
import com.zinkworks.model.CustomerAccount;
import com.zinkworks.model.DispensedAmount;
import com.zinkworks.repository.CustomerAccountRepository;
import com.zinkworks.utils.AmountUtil;
import com.zinkworks.utils.LoggingUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DispenseServiceImpl implements DispenseService{

    @Autowired
    private CustomerAccountRepository customerAccountRepository;

    @Autowired
    private AtmServiceImpl atmService;

    @Override
    public DispensedAmount dispense(Integer accountNumber, Integer pin, double amountRequested) throws InvalidReequestAmountException {

        CustomerAccount customerAccount = customerAccountRepository.getCustomerAccount(accountNumber, pin);

        double dispenseAmount = AmountUtil.getDispenseAmount(customerAccount, amountRequested);

        Double atmBalance = atmService.getBalance();

        validateRequestAmount(dispenseAmount, atmBalance);


        LoggingUtils.logMessage("INFO", this.getClass().getSimpleName(), Double.toString(dispenseAmount), "Dispensing from customerAccount - [account_number: " + accountNumber + "] [dispense_amount: " + dispenseAmount + "]");

        atmService.updateAtm(dispenseAmount);
        customerAccountRepository.withDrawAmount(customerAccount, dispenseAmount);

        return new DispensedAmount(dispenseAmount, customerAccount);
    }

    private void validateRequestAmount(double dispenseAmount, Double atmBalance) throws InvalidReequestAmountException {
        if (dispenseAmount > atmBalance) {
            throw new InvalidReequestAmountException("Invalid Request amount", System.currentTimeMillis());
        }
    }

}
