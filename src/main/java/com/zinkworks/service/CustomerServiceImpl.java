package com.zinkworks.service;

import com.zinkworks.exceptions.AccountNotValidatedException;
import com.zinkworks.model.CustomerAccount;
import com.zinkworks.repository.CustomerAccountRepository;
import com.zinkworks.utils.LoggingUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.zinkworks.ZinWorksConstants.*;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerAccountRepository customerAccountRepository;

    @Override
    public void isValidCustomer(Integer accountNumber, Integer pin) throws AccountNotValidatedException {
        CustomerAccount customerAccount = this.customerAccountRepository.getCustomerAccount(accountNumber, pin);

        if (customerAccount == null) {
            LoggingUtils.logMessage(LOG_LEVEL_ERROR, this.getClass().getSimpleName(), Integer.toString(accountNumber), String.format(EXCEPTION_INVALID_CUSTOMER_WITH_ACCOUNT_NUMBER_S_PIN_S, accountNumber, pin));
            throw new AccountNotValidatedException(String.format(EXCEPTION_INVALID_CUSTOMER_WITH_ACCOUNT_NUMBER_S, accountNumber), System.currentTimeMillis());
        }
    }

}
