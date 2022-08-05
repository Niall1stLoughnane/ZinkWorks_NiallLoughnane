package com.zinworks.utils;

import com.zinworks.model.Account;

public final class AmountUtil {

    private AmountUtil(){}

    public static double getDispenseAmount(Account account, double amountRequested) {
        Double accountBalance = account.getBalance();

        if (accountBalance < amountRequested) {
            return accountBalance;
        }

        return amountRequested;
    }
}
