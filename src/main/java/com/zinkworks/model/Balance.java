package com.zinkworks.model;

import lombok.Data;

@Data
public class Balance {

    private Integer accountNumber;
    private double balance;
    private double maximumWithdrawlAmount;

    public Balance(Integer accountNumber, double balance, double maximumWithdrawlAmount) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.maximumWithdrawlAmount = maximumWithdrawlAmount;
    }
}
