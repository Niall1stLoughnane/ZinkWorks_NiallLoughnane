package com.zinkworks.exceptions;

public abstract class ZinWorksException extends Throwable {

    private String message;
    private Long systemTime;

    ZinWorksException(String message, Long systemTime) {
        this.message = message;
        this.systemTime = systemTime;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public Long getSystemTime() {
        return systemTime;
    }
}
