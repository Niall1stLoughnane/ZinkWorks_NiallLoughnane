package com.zinworks.service;

import com.zinworks.exceptions.AccountNotExistExeption;
import com.zinworks.exceptions.AtmZeroCashExeption;
import com.zinworks.model.Account;
import com.zinworks.model.User;
import com.zinworks.repository.UserAccountRepository;
import com.zinworks.utils.AmountUtil;
import com.zinworks.utils.LoggingUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private UserAccountRepository userAccountRepository;

    @Autowired
    private AtmServiceImpl atmService;

    @Override
    public User getAccountDetails(String accountNumber, String pin) throws AccountNotExistExeption, AtmZeroCashExeption {

        LoggingUtils.logMessage("INFO", this.getClass().getSimpleName(), accountNumber, "Getting account details");

        Account account = userAccountRepository.getAccount(accountNumber, pin, true);

        double dispenseAmount = AmountUtil.getDispenseAmount(account, account.getBalance());

        double maximumWithdrawlAmount = atmService.getTotalAllowedDispenseAmount(dispenseAmount);

        LoggingUtils.logMessage("INFO", this.getClass().getSimpleName(), accountNumber, "Dispensing amount ["+ dispenseAmount + "]");

        return new User(accountNumber, account.getBalance(), maximumWithdrawlAmount);
    }
}
