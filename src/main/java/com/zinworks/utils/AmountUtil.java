package com.zinworks.utils;

import com.zinworks.model.Account;

public class AmountUtil {

    public static double getDispenseAmount(Account account, double amountRequested) {

        if (account.getBalance() < amountRequested) {
            return account.getBalance();
        }

        return amountRequested;
    }
}
