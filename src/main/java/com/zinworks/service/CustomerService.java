package com.zinworks.service;

import com.zinworks.exceptions.AccountNotValidatedExeption;
import com.zinworks.exceptions.CustomerInvalidException;
import org.springframework.stereotype.Service;

public interface CustomerService {

    void isValidCustomer(Integer accountNumber, Integer pin) throws CustomerInvalidException, AccountNotValidatedExeption;
}
