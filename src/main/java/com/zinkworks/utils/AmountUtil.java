package com.zinkworks.utils;

import com.zinkworks.exceptions.InvalidReequestAmountException;
import com.zinkworks.model.CustomerAccount;

public final class AmountUtil {

    private AmountUtil(){}

    public static double getDispenseAmount(CustomerAccount customerAccount, double amountRequested) throws InvalidReequestAmountException {


        if(customerAccount.getBalance() > amountRequested) {
            return amountRequested;
        }

        if((customerAccount.getBalance() + customerAccount.getOverDraft()) > amountRequested) {
            return amountRequested;
        }

        LoggingUtils.logMessage("ERROR", "AmountUtil", customerAccount.getAccountNumber(), "Invalid Request Amount: " + amountRequested);
        throw new InvalidReequestAmountException("Invalid Request Amount: " + amountRequested, System.currentTimeMillis());
    }
}
