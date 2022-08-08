/**
 * Author:    Niall Loughnane
 * Created:   08.08.2020
 *
 * This class
 **/

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
