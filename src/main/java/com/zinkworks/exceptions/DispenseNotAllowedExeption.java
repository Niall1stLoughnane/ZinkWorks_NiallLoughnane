/**
 * Author:    Niall Loughnane
 * Created:   08.08.2020
 *
 * This class is an exception class for when a dispense/withrawal isnt allowed
 **/

package com.zinkworks.exceptions;

public class DispenseNotAllowedExeption extends ZinWorksException {

    public DispenseNotAllowedExeption(String message, Long id) {
        super(message, id);
    }

}
