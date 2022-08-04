package com.zinworks.repository;

import com.zinworks.exceptions.ZinWorksExeption;
import com.zinworks.model.Account;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserAccountRepository {

    private Map<String, Account> accountList = new HashMap<>();

    @PostConstruct
    public void initialize() {
        accountList.put("123456789", new Account("123456789", "1234 800", 200));
        accountList.put("987654321", new Account("987654321", "4321 1230", 150));
    }

    public Account getAccount(String accountNumber, String pin, boolean verifyPin) throws ZinWorksExeption {
        Account account = accountList.get(accountNumber);

        if (account == null) {
            throw new ZinWorksExeption("Account Doest exist: " + accountNumber);
        }

        if (verifyPin && !StringUtils.equals(account.getPin(), pin)) {
            throw new ZinWorksExeption("Account Doest exist: " + accountNumber);
        }

        return account;
    }


    public void updateAccount(Account account) throws ZinWorksExeption {
        String accountNumber = account.getAccountNumber();

        if (getAccount(accountNumber, "", false) == null) {
            throw new ZinWorksExeption("account doesnt exist: " + accountNumber);
        }

        this.accountList.put(accountNumber, account);
    }
}
