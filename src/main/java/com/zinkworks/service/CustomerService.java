package com.zinkworks.service;

import com.zinkworks.exceptions.AccountNotValidatedException;
import com.zinkworks.exceptions.CustomerInvalidException;

public interface CustomerService {

    void isValidCustomer(Integer accountNumber, Integer pin) throws CustomerInvalidException, AccountNotValidatedException;
}
