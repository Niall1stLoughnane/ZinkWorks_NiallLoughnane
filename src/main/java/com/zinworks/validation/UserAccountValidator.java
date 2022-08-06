package com.zinworks.validation;

import com.zinworks.exceptions.AccountNotValidatedExeption;
import com.zinworks.model.Account;
import com.zinworks.utils.LoggingUtils;
import org.apache.commons.lang3.StringUtils;

public final class UserAccountValidator {

    private UserAccountValidator(){}

    public static void vaidateAccount(Account account, String pin) throws AccountNotValidatedExeption {
        LoggingUtils.logMessage("INFO", "UserAccountValidator", account.getAccountNumber(), "validating account");
        if (!StringUtils.equals(account.getPin(), pin)) {
            LoggingUtils.logMessage("ERROR", "UserAccountValidator", account.getAccountNumber(), "Account not validated: [Account Number: " + account.getAccountNumber() +"] [Account_Pin: " +account.getPin() + "] [Request pin:" + pin +"]]");
            throw new AccountNotValidatedExeption("Account not validated", System.currentTimeMillis());
        }
    }

}
