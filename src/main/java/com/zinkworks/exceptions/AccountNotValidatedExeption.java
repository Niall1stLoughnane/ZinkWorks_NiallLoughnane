package com.zinkworks.exceptions;

public class AccountNotValidatedExeption extends ZinWorksExeption {

    public AccountNotValidatedExeption(String message, Long id) {
        super(message, id);
    }

}
