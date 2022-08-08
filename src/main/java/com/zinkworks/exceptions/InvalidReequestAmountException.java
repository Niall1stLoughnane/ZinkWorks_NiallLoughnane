/**
 * Author:    Niall Loughnane
 * Created:   08.08.2020
 *
 * This class is an exception class for when there is an invalid request
 **/

package com.zinkworks.exceptions;

public class InvalidReequestAmountException extends ZinWorksException {

    public InvalidReequestAmountException(String message, Long id) {
        super(message, id);
    }

}
