package com.zinworks.service;

import com.zinworks.exceptions.AccountNotExistExeption;
import com.zinworks.exceptions.AccountNotValidatedExeption;
import com.zinworks.exceptions.AtmZeroCashExeption;
import com.zinworks.exceptions.DispenseNotAllowedExeption;
import com.zinworks.model.Account;
import com.zinworks.model.DispensedAmount;
import com.zinworks.repository.UserAccountRepository;
import com.zinworks.utils.AmountUtil;
import com.zinworks.utils.LoggingUtils;
import com.zinworks.validation.UserAccountValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.zinworks.ZinWorksConstants.EXCEPTION_DISPENSE_NOT_ALLOWED;

@Service
public class DispenseServiceImpl implements DispenseService{

    @Autowired
    private UserAccountRepository userAccountRepository;

    @Autowired
    private AtmServiceImpl atmService;

    @Override
    public DispensedAmount dispense(String accountNumber, String pin, double amountRequested) throws AccountNotValidatedExeption, DispenseNotAllowedExeption, AtmZeroCashExeption, AccountNotExistExeption {

        LoggingUtils.logMessage("INFO", this.getClass().getSimpleName(), accountNumber, "Dispensing from account");

        Account account = userAccountRepository.getAccount(accountNumber, pin, true);

        UserAccountValidator.vaidateAccount(account, pin);

        double dispenseAmount = AmountUtil.getDispenseAmount(account, amountRequested);

        if (dispenseAmount <= 0d) {
            LoggingUtils.logMessage("ERROR", this.getClass().getSimpleName(), Double.toString(dispenseAmount), "Exception thrown as dispense amount is0 or less - [account_number: " + accountNumber + "]");
            throw new DispenseNotAllowedExeption(EXCEPTION_DISPENSE_NOT_ALLOWED, System.currentTimeMillis());
        }

        dispenseAmount = atmService.getTotalAllowedDispenseAmount(dispenseAmount);

        validateDispenseAmount(dispenseAmount, account);

        LoggingUtils.logMessage("INFO", this.getClass().getSimpleName(), Double.toString(dispenseAmount), "Dispensing from account - [account_number: " + accountNumber + "] [dispense_amount: " + dispenseAmount + "]");

        atmService.updateAtm(dispenseAmount);
        account.setBalance(account.getBalance() - dispenseAmount);
        userAccountRepository.updateAccount(account);

        return new DispensedAmount(dispenseAmount);
    }

    private void validateDispenseAmount(double dispenseAmount, Account account) throws DispenseNotAllowedExeption {
        if (dispenseAmount <= 0d) {
            LoggingUtils.logMessage("ERROR", this.getClass().getSimpleName(), Double.toString(dispenseAmount), "Exception thrown as dispense amount is 0 or less " + dispenseAmount);
            throw new DispenseNotAllowedExeption("Dispense not allowed", System.currentTimeMillis());
        }
        if (account.getBalance() < dispenseAmount) {
            LoggingUtils.logMessage("ERROR", this.getClass().getSimpleName(), Double.toString(dispenseAmount), "Exception thrown as account balance is less than dispense amount: [account balance: " + account.getBalance() + "] - [dispense amount: "+ dispenseAmount + "]");
            throw new DispenseNotAllowedExeption("Dispense not allowed", System.currentTimeMillis());
        }
    }

}
