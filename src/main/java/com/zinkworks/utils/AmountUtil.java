/**
 * Author:    Niall Loughnane
 * Created:   08.08.2020
 *
 * This class is a utility for processing amounts
 **/

package com.zinkworks.utils;

import com.zinkworks.exceptions.InvalidReequestAmountException;
import com.zinkworks.model.CustomerAccount;

import static com.zinkworks.ZinWorksConstants.EXCEPTION_INVALID_REQUEST_AMOUNT;
import static com.zinkworks.ZinWorksConstants.LOG_LEVEL_ERROR;

public final class AmountUtil {

    private AmountUtil(){}

    public static double getDispenseAmount(CustomerAccount customerAccount, double amountRequested) throws InvalidReequestAmountException {


        if(customerAccount.getBalance() > amountRequested) {
            return amountRequested;
        }

        if((customerAccount.getBalance() + customerAccount.getOverDraft()) > amountRequested) {
            return amountRequested;
        }

        LoggingUtils.logMessage(LOG_LEVEL_ERROR, "AmountUtil", customerAccount.getAccountNumber(), String.format(EXCEPTION_INVALID_REQUEST_AMOUNT, amountRequested));
        throw new InvalidReequestAmountException(String.format(EXCEPTION_INVALID_REQUEST_AMOUNT, amountRequested), System.currentTimeMillis());
    }
}
