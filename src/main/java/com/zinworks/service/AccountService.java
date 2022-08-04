package com.zinworks.service;

import com.zinworks.exceptions.ZinWorksExeption;
import com.zinworks.model.Account;
import com.zinworks.model.User;
import com.zinworks.repository.UserAccountRepository;
import com.zinworks.utils.AmountUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private UserAccountRepository userAccountRepository;

    @Autowired
    private AtmService atmService;

    public User getAccountDetails(String accountNumber, String pin) throws ZinWorksExeption {
        Account account = userAccountRepository.getAccount(accountNumber, pin, true);

        double dispenseAmount = AmountUtil.getDispenseAmount(account, account.getBalance());

        double maximumWithdrawlAmount = atmService.getTotalAllowedDispenseAmount(dispenseAmount);

        return new User(accountNumber, account.getBalance(), maximumWithdrawlAmount);
    }
}
