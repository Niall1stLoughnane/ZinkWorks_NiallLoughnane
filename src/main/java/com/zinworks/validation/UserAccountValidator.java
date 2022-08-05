package com.zinworks.validation;

import com.zinworks.exceptions.ZinWorksExeption;
import com.zinworks.model.Account;
import com.zinworks.utils.LoggingUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

public class UserAccountValidator {

    public static void vaidateAccount(Account account, String pin) throws ZinWorksExeption {
        LoggingUtils.logMessage("INFO", "UserAccountValidator", account.getAccountNumber(), "validating account");
        if (!StringUtils.equals(account.getPin(), pin)) {
            LoggingUtils.logMessage("ERROR", "UserAccountValidator", account.getAccountNumber(), "pins are not the same: [pin:" + pin +"]" );
            throw new ZinWorksExeption("account not validated");
        }
    }

}
