package com.zinkworks.service;

import com.zinkworks.exceptions.InvalidReequestAmountException;
import com.zinkworks.model.CustomerAccount;
import com.zinkworks.model.DispensedAmount;
import com.zinkworks.repository.CustomerAccountRepository;
import com.zinkworks.utils.AmountUtil;
import com.zinkworks.utils.LoggingUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.zinkworks.ZinWorksConstants.DISPENSING_FROM_CUSTOMER_ACCOUNT_ACCOUNT_NUMBER_S_DISPENSE_AMOUNT;
import static com.zinkworks.ZinWorksConstants.EXCEPTION_INVALID_REQUEST_AMOUNTT;

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


        LoggingUtils.logMessage("INFO", this.getClass().getSimpleName(), Double.toString(dispenseAmount), String.format(DISPENSING_FROM_CUSTOMER_ACCOUNT_ACCOUNT_NUMBER_S_DISPENSE_AMOUNT, accountNumber, dispenseAmount));

        atmService.updateAtm(dispenseAmount);
        customerAccountRepository.withDrawAmount(customerAccount, dispenseAmount);

        return new DispensedAmount(dispenseAmount, customerAccount);
    }

    private void validateRequestAmount(double dispenseAmount, Double atmBalance) throws InvalidReequestAmountException {
        if (dispenseAmount > atmBalance) {
            throw new InvalidReequestAmountException(EXCEPTION_INVALID_REQUEST_AMOUNTT, System.currentTimeMillis());
        }
    }

}
