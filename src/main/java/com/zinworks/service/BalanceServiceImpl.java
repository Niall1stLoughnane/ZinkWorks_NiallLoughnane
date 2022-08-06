package com.zinworks.service;

import com.zinworks.model.Balance;
import com.zinworks.model.CustomerAccount;
import com.zinworks.repository.CustomerAccountRepository;
import com.zinworks.utils.LoggingUtils;
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
