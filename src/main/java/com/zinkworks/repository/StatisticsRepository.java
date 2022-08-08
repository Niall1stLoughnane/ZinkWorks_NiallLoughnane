package com.zinkworks.repository;

import com.zinkworks.model.Statistics;
import org.springframework.stereotype.Service;

@Service
public class StatisticsRepository {

    private final Statistics statistics = new Statistics();

    public void addBalanceLoginFailure(Integer accessNumber) {
        this.statistics.numberOfBalanceLoginFailures++;
        this.statistics.loginBalanceFailuresAccessNumbers.add(accessNumber);
    }

    public void addWithdrawalLoginFailure(Integer accessNumber) {
        this.statistics.numberOfWithdrawalLoginFailures++;
        this.statistics.loginWithdrawalFailuresAccessNumbers.add(accessNumber);
    }

    public void addBalanceRequest() {
        this.statistics.numberOfBalanceRequests++;
    }

    public void addWithdrawal(double amount) {
        this.statistics.numberOfWithdrawals++;
        this.statistics.totalWithdrawalAmount = this.statistics.totalWithdrawalAmount + amount;
    }

    public void addWithdrawalSuccessful(Double amount) {
        this.statistics.numberOfWithdrawalsSuccessful++;
        this.statistics.totalWithdrawalSuccessfulAmount = this.statistics.totalWithdrawalSuccessfulAmount + amount;
    }

    public void addWithdrawalFailure(Double amount) {
        this.statistics.numberOfWithdrawalsFailures++;
        this.statistics.totalWithdrawalFailedAmount = this.statistics.totalWithdrawalFailedAmount + amount;
    }

    public Statistics getAllStatistics() {
        return this.statistics;
    }

}
