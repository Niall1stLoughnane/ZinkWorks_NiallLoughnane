package com.zinworks.service;

import com.zinworks.exceptions.*;
import com.zinworks.model.CustomerAccount;
import com.zinworks.model.DispensedAmount;
import com.zinworks.repository.CustomerAccountRepository;
import com.zinworks.utils.AmountUtil;
import com.zinworks.utils.LoggingUtils;
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

        LoggingUtils.logMessage("INFO", this.getClass().getSimpleName(), "" + accountNumber, "Dispensing from customerAccount");
        CustomerAccount customerAccount = customerAccountRepository.getCustomerAccount(accountNumber, pin);

        double dispenseAmount = AmountUtil.getDispenseAmount(customerAccount, amountRequested);

        Double atmBalance = atmService.getBalance();

        validateRequestAmount(dispenseAmount, atmBalance);


        LoggingUtils.logMessage("INFO", this.getClass().getSimpleName(), Double.toString(dispenseAmount), "Dispensing from customerAccount - [account_number: " + accountNumber + "] [dispense_amount: " + dispenseAmount + "]");

        atmService.updateAtm(dispenseAmount);
        customerAccountRepository.withDrawAmount(customerAccount, dispenseAmount);

        return new DispensedAmount(dispenseAmount);
    }

    private void validateRequestAmount(double dispenseAmount, Double atmBalance) throws InvalidReequestAmountException {
        if (dispenseAmount > atmBalance) {
            throw new InvalidReequestAmountException("Invalid Request amount", System.currentTimeMillis());
        }
    }

}
