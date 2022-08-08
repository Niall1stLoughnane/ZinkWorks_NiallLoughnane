package com.zinkworks.repository;

import com.zinkworks.model.Statistics;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class StatisticsRepositoryTest {


    private StatisticsRepository statisticsRepository = new StatisticsRepository();

    @Test
    public void testAddBalanceLoginFailure(){
        assertEquals(0, statisticsRepository.getAllStatistics().numberOfBalanceLoginFailures);

        statisticsRepository.addBalanceLoginFailure(1);

        assertEquals(1, statisticsRepository.getAllStatistics().numberOfBalanceLoginFailures);
        assertEquals(1, statisticsRepository.getAllStatistics().getLoginBalanceFailuresAccessNumbers().size());
        assertEquals(1, statisticsRepository.getAllStatistics().getLoginBalanceFailuresAccessNumbers().get(0));
    }

    @Test
    public void testAddWithdrawalLoginFailure(){
        assertEquals(0, statisticsRepository.getAllStatistics().numberOfWithdrawalLoginFailures);

        statisticsRepository.addWithdrawalLoginFailure(1);

        assertEquals(1, statisticsRepository.getAllStatistics().numberOfWithdrawalLoginFailures);
        assertEquals(1, statisticsRepository.getAllStatistics().getLoginWithdrawalFailuresAccessNumbers().size());
        assertEquals(1, statisticsRepository.getAllStatistics().getLoginWithdrawalFailuresAccessNumbers().get(0));
    }

    @Test
    public void testAddBalanceRequest(){
        assertEquals(0, statisticsRepository.getAllStatistics().numberOfBalanceRequests);

        statisticsRepository.addBalanceRequest();

        assertEquals(1, statisticsRepository.getAllStatistics().numberOfBalanceRequests);
    }

    @Test
    public
    void testAddWithdrawal() {
        assertEquals(0, statisticsRepository.getAllStatistics().numberOfWithdrawals);
        assertEquals(0, statisticsRepository.getAllStatistics().getTotalWithdrawalAmount());

        statisticsRepository.addWithdrawal(300);

        assertEquals(1, statisticsRepository.getAllStatistics().numberOfWithdrawals);
        assertEquals(300, statisticsRepository.getAllStatistics().getTotalWithdrawalAmount());
    }

    @Test
    public void testAddWithdrawalSuccessful(){
        assertEquals(0, statisticsRepository.getAllStatistics().numberOfWithdrawalsSuccessful);
        assertEquals(0, statisticsRepository.getAllStatistics().getTotalWithdrawalSuccessfulAmount());

        statisticsRepository.addWithdrawalSuccessful(301d);

        assertEquals(1, statisticsRepository.getAllStatistics().numberOfWithdrawalsSuccessful);
        assertEquals(301d, statisticsRepository.getAllStatistics().getTotalWithdrawalSuccessfulAmount());
    }

    @Test
    public void testAddWithdrawalFailure(){
        assertEquals(0, statisticsRepository.getAllStatistics().numberOfWithdrawalsFailures);
        assertEquals(0, statisticsRepository.getAllStatistics().getTotalWithdrawalFailedAmount());

        statisticsRepository.addWithdrawalFailure(302d);

        assertEquals(1, statisticsRepository.getAllStatistics().numberOfWithdrawalsFailures);
        assertEquals(302d, statisticsRepository.getAllStatistics().getTotalWithdrawalFailedAmount());
    }

    @Test
    public void testGetAllStatistics(){
        Statistics allStatistics = statisticsRepository.getAllStatistics();
        System.out.println();

    }
}
