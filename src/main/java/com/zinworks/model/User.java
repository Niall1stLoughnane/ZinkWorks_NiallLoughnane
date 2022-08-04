package com.zinworks.model;

import lombok.Data;

@Data
public class User {

    private String accountNumber;
    private double balance;
    private double allowedWithdrawalAmount;

    public User(String accountNumber, double balance, double allowedWithdrawalAmount) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.allowedWithdrawalAmount = allowedWithdrawalAmount;
    }
}
