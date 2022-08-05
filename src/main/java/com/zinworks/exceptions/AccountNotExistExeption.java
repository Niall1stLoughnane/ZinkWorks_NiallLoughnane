package com.zinworks.exceptions;

public class AccountNotExistExeption extends ZinWorksExeption {

    public AccountNotExistExeption(String message, Long id) {
        super(message, id);
    }

}
