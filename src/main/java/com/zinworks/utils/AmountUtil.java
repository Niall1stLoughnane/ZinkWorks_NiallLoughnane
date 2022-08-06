package com.zinworks.utils;

import com.zinworks.exceptions.InvalidReequestAmountException;
import com.zinworks.model.CustomerAccount;

public final class AmountUtil {

    private AmountUtil(){}

    public static double getDispenseAmount(CustomerAccount customerAccount, double amountRequested) throws InvalidReequestAmountException {


        if(customerAccount.getBalance() > amountRequested) {
            return amountRequested;
        }

        if((customerAccount.getBalance() + customerAccount.getOverDraft()) > amountRequested) {
            return amountRequested;
        }

        throw new InvalidReequestAmountException("Invalid Request Amount: " + amountRequested, System.currentTimeMillis());
    }
}
