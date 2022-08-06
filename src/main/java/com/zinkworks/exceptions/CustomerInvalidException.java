package com.zinkworks.exceptions;

public class CustomerInvalidException extends ZinWorksExeption {

    public CustomerInvalidException(String message, Long id) {
        super(message, id);
    }

}
