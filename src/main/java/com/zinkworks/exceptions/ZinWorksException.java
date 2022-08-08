/**
 * Author:    Niall Loughnane
 * Created:   08.08.2020
 *
 * This class is a base exception class where other exceptions inherit from
 **/

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
