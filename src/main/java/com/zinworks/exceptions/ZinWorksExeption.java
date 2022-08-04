package com.zinworks.exceptions;

public class ZinWorksExeption extends Throwable {

    private String message;

    public ZinWorksExeption(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
