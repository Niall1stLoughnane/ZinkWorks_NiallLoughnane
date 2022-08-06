package com.zinkworks.exceptions;

public class InvalidReequestAmountException extends ZinWorksException {

    public InvalidReequestAmountException(String message, Long id) {
        super(message, id);
    }

}
