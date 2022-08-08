package com.zinkworks.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Statistics {

    public Long numberOfBalanceLoginFailures = 0l;
    public List<Integer> loginBalanceFailuresAccessNumbers = new ArrayList<>();
    public Long numberOfWithdrawalLoginFailures = 0l;
    public List<Integer> loginWithdrawalFailuresAccessNumbers = new ArrayList<>();
    public long numberOfBalanceRequests = 0;
    public long numberOfWithdrawals = 0;
    public Double totalWithdrawalAmount = 0d;
    public long numberOfWithdrawalsSuccessful = 0;
    public Double totalWithdrawalSuccessfulAmount = 0d;
    public long numberOfWithdrawalsFailures = 0;
    public Double totalWithdrawalFailedAmount = 0d;

}
