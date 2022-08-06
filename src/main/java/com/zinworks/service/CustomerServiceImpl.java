package com.zinworks.service;

import com.zinworks.exceptions.CustomerInvalidException;
import com.zinworks.model.CustomerAccount;
import com.zinworks.repository.CustomerAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerAccountRepository customerAccountRepository;

    @Override
    public void isValidCustomer(Integer accountNumber, Integer pin) throws CustomerInvalidException {
        CustomerAccount customerAccount = this.customerAccountRepository.getCustomerAccount(accountNumber, pin);

        if (customerAccount == null) {
            throw new CustomerInvalidException("Invalid Customer with Account Number [" + accountNumber + "]", System.currentTimeMillis());
        }
    }

}
