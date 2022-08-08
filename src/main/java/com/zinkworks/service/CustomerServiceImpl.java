/**
 * Author:    Niall Loughnane
 * Created:   08.08.2020
 *
 * This class this is a service for processing customer information
 **/

package com.zinkworks.service;

import com.zinkworks.enums.RequestType;
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
    @Autowired
    private StatisticsService statisticsService;

    @Override
    public void isValidCustomer(Integer accountNumber, Integer pin, RequestType requestType) throws AccountNotValidatedException {
        CustomerAccount customerAccount = this.customerAccountRepository.getCustomerAccount(accountNumber, pin);

        if (customerAccount == null) {
            setStatistics(accountNumber, requestType);
            LoggingUtils.logMessage(LOG_LEVEL_ERROR, this.getClass().getSimpleName(), Integer.toString(accountNumber), String.format(EXCEPTION_INVALID_CUSTOMER_WITH_ACCOUNT_NUMBER_S_PIN, accountNumber, pin));
            throw new AccountNotValidatedException(String.format(EXCEPTION_INVALID_CUSTOMER_WITH_ACCOUNT_NUMBER, accountNumber), System.currentTimeMillis());
        }
    }

    private void setStatistics(Integer accountNumber, RequestType requestType) {
        if (requestType.equals(RequestType.Balance)){
            statisticsService.addBalanceLoginFailure(accountNumber);
        } else if (requestType.equals(RequestType.Withdrawal)){
            statisticsService.addWithdrawalLoginFailure(accountNumber);
        }
    }

}
