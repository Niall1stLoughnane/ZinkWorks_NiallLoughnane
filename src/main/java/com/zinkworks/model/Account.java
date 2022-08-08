/**
 * Author:    Niall Loughnane
 * Created:   08.08.2020
 *
 * This class
 **/

package com.zinkworks.model;

import lombok.Data;

@Data
public class Account {

    private String accountNumber;
    private String pin;
    private Double balance = 0d;

    public Account(String accountNumber, String pin, int amount) {
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.balance += amount;
    }

}
