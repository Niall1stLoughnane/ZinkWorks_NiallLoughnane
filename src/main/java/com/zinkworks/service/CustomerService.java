/**
 * Author:    Niall Loughnane
 * Created:   08.08.2020
 *
 * This class
 **/

package com.zinkworks.service;

import com.zinkworks.enums.RequestType;
import com.zinkworks.exceptions.AccountNotValidatedException;
import com.zinkworks.exceptions.CustomerInvalidException;

public interface CustomerService {

    void isValidCustomer(Integer accountNumber, Integer pin, RequestType requestType) throws CustomerInvalidException, AccountNotValidatedException;
}
