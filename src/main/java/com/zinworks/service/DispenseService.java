package com.zinworks.service;

import com.zinworks.exceptions.ZinWorksExeption;
import com.zinworks.model.Account;
import com.zinworks.model.DispensedAmount;
import com.zinworks.repository.UserAccountRepository;
import com.zinworks.utils.AmountUtil;
import com.zinworks.validation.UserAccountValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DispenseService {

    @Autowired
    private UserAccountRepository userAccountRepository;

    @Autowired
    private AtmService atmService;

    @Autowired
    private UserAccountValidator userAccountValidator;

    public DispensedAmount dispense(String accountNumber, String pin, double amountRequested) throws ZinWorksExeption {
        Account account = userAccountRepository.getAccount(accountNumber, pin, true);

        userAccountValidator.vaidateAccount(account, pin);

        double dispenseAmount = AmountUtil.getDispenseAmount(account, amountRequested);

        if (dispenseAmount <= 0d) {
            throw new ZinWorksExeption("Dispense not allowed");
        }

        dispenseAmount = atmService.getTotalAllowedDispenseAmount(dispenseAmount);

        validateDispenseAmount(dispenseAmount, account);

        atmService.updateAtm(dispenseAmount);
        account.setBalance(account.getBalance() - dispenseAmount);
        userAccountRepository.updateAccount(account);

        return new DispensedAmount(dispenseAmount);
    }

    private void validateDispenseAmount(double dispenseAmount, Account account) throws ZinWorksExeption {
        if (dispenseAmount <= 0d) {
            throw new ZinWorksExeption("Dispense not allowed");
        }
        if (account.getBalance() <= 0d) {
            throw new ZinWorksExeption("Dispense not allowed");
        }
        if (account.getBalance() < dispenseAmount) {
            throw new ZinWorksExeption("Dispense not allowed");
        }
    }

}
