package com.zinkworks.service;

import com.zinkworks.model.Statistics;

public interface StatisticsService {

    void addBalanceLoginFailure(Integer accessNumber);
    void addWithdrawalLoginFailure(Integer accessNumber);

    void addBalanceRequest();

    void addWithdrawal(double amount);

    void addWithdrawalSuccessful(Double amount);

    void addWithdrawalFailure(Double amount);

    Statistics getAllStatistics();
}
