package com.zinworks.validation;

import com.zinworks.exceptions.ZinWorksExeption;
import com.zinworks.model.Account;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

public class UserAccountValidator {

    public static void vaidateAccount(Account account, String pin) throws ZinWorksExeption {
        if (!StringUtils.equals(account.getPin(), pin)) {
            throw new ZinWorksExeption("account not validated");
        }
    }

}
