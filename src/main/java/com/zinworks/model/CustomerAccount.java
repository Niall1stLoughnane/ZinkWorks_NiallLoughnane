package com.zinworks.model;

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
