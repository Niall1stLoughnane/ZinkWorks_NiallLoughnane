/**
 * Author:    Niall Loughnane
 * Created:   08.08.2020
 *
 * This class this is a model class that represents a customers account
 **/

package com.zinkworks.model;

import lombok.Data;

@Data
public class CustomerAccount {

    private String accountNumber;
    private Integer pin;
    private Double balance = 0d;
    private Double overDraft = 0d;

    public CustomerAccount(String accountNumber, Integer pin, Double balance, Double overDraft) {
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.balance += balance;
        this.overDraft += overDraft;
    }

}
