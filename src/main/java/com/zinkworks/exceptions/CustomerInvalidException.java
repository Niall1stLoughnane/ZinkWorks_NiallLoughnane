/**
 * Author:    Niall Loughnane
 * Created:   08.08.2020
 *
 * This class is an exception class for when the customer is invalid
 **/

package com.zinkworks.exceptions;

public class CustomerInvalidException extends ZinWorksException {

    public CustomerInvalidException(String message, Long id) {
        super(message, id);
    }

}
