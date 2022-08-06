package com.zinkworks.exceptions;

public class InvalidReequestAmountException extends ZinWorksExeption {

    public InvalidReequestAmountException(String message, Long id) {
        super(message, id);
    }

}
