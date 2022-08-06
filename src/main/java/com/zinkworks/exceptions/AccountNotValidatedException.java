package com.zinkworks.exceptions;

public class AccountNotValidatedException extends ZinWorksException {

    public AccountNotValidatedException(String message, Long id) {
        super(message, id);
    }

}
