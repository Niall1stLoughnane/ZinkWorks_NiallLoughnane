/**
 * Author:    Niall Loughnane
 * Created:   08.08.2020
 *
 * This class is an exception class for when the account is not validated
 **/

package com.zinkworks.exceptions;

public class AccountNotValidatedException extends ZinWorksException {

    public AccountNotValidatedException(String message, Long id) {
        super(message, id);
    }

}
