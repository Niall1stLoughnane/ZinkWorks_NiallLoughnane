package com.zinworks.exceptions;

public abstract class ZinWorksExeption extends Throwable {

    private String message;

    ZinWorksExeption(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
