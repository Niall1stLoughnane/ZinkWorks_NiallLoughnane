package com.zinkworks.exceptions;

public class CustomerInvalidException extends ZinWorksException {

    public CustomerInvalidException(String message, Long id) {
        super(message, id);
    }

}
