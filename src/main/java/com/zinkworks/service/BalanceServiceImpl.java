package com.zinkworks.service;

import com.zinkworks.model.Balance;
import com.zinkworks.model.CustomerAccount;
import com.zinkworks.repository.CustomerAccountRepository;
import com.zinkworks.utils.LoggingUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BalanceServiceImpl implements BalanceService {

    @Autowired
    private CustomerAccountRepository customerAccountRepository;

    @Autowired
    private AtmServiceImpl atmService;

    @Override
    public Balance getBalanceDetails(Integer accountNumber, Integer pin) {

        CustomerAccount customerAccount = customerAccountRepository.getCustomerAccount(accountNumber, pin);

        double maximumWithdrawlAmount = customerAccount.getBalance() + customerAccount.getOverDraft();

        LoggingUtils.logMessage("INFO", this.getClass().getSimpleName(), Integer.toString(accountNumber), "Balance Successfully Retrieved [" + accountNumber + "]");

        return new Balance(accountNumber, customerAccount.getBalance(), maximumWithdrawlAmount);
    }
}
