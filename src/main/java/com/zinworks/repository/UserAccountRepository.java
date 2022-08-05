package com.zinworks.repository;

import com.zinworks.exceptions.AccountNotExistExeption;
import com.zinworks.exceptions.AccountNotValidatedExeption;
import com.zinworks.model.Account;
import com.zinworks.validation.UserAccountValidator;
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

    public Account getAccount(String accountNumber, String pin, boolean verifyPin) throws AccountNotExistExeption, AccountNotValidatedExeption {
        Account account = accountList.get(accountNumber);

        if (account == null) {
            throw new AccountNotExistExeption("Account Doest exist: " + accountNumber, Integer.parseInt(accountNumber));
        }

        if (verifyPin) {
            UserAccountValidator.vaidateAccount(account, pin);
        }

        return account;
    }


    public void updateAccount(Account account) {
        this.accountList.put(account.getAccountNumber(), account);
    }
}
