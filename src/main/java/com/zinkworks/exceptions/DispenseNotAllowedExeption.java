package com.zinkworks.exceptions;

public class DispenseNotAllowedExeption extends ZinWorksException {

    public DispenseNotAllowedExeption(String message, Long id) {
        super(message, id);
    }

}
