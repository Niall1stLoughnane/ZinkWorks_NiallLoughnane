/**
 * Author:    Niall Loughnane
 * Created:   08.08.2020
 *
 * This class this is a service that processes statistical information
 **/

package com.zinkworks.service;

import com.zinkworks.model.Statistics;
import com.zinkworks.repository.StatisticsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatisticsServiceImpl implements StatisticsService {

    @Autowired
    private StatisticsRepository statisticsRepository;

    @Override
    public void addBalanceLoginFailure(Integer accessNumber) {
        this.statisticsRepository.addBalanceLoginFailure(accessNumber);
    }

    @Override
    public void addWithdrawalLoginFailure(Integer accessNumber) {
        this.statisticsRepository.addWithdrawalLoginFailure(accessNumber);
    }

    @Override
    public void addBalanceRequest() {
        this.statisticsRepository.addBalanceRequest();
    }

    @Override
    public void addWithdrawal(double amount) {
        this.statisticsRepository.addWithdrawal(amount);
    }

    @Override
    public void addWithdrawalSuccessful(Double amount) {
        this.statisticsRepository.addWithdrawalSuccessful(amount);
    }

    @Override
    public void addWithdrawalFailure(Double amount) {
        this.statisticsRepository.addWithdrawalFailure(amount);
    }

    @Override
    public Statistics getAllStatistics() {
        return this.statisticsRepository.getAllStatistics();
    }
}
