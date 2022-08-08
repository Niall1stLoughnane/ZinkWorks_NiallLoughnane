package com.zinkworks.service;

import com.zinkworks.repository.StatisticsRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.eq;

@ExtendWith(MockitoExtension.class)
public class StatisticsServiceImplTest {

    @InjectMocks
    private StatisticsServiceImpl statisticsService;

    @Mock
    private StatisticsRepository mockStatisticsRepository;

    @DisplayName("Test - StatisticsServiceImplTest - testAddBalanceLoginFailure")
    @Test
    public void testAddBalanceLoginFailure() {
        this.statisticsService.addBalanceLoginFailure(1);

        Mockito.verify(mockStatisticsRepository).addBalanceLoginFailure(eq(1));
        Mockito.verifyNoMoreInteractions(mockStatisticsRepository);
    }

    @DisplayName("Test - StatisticsServiceImplTest - testAddWithdrawalLoginFailure")
    @Test
    public void testAddWithdrawalLoginFailure() {
        this.statisticsService.addWithdrawalLoginFailure(2);

        Mockito.verify(mockStatisticsRepository).addWithdrawalLoginFailure(eq(2));
        Mockito.verifyNoMoreInteractions(mockStatisticsRepository);
    }

    @DisplayName("Test - StatisticsServiceImplTest - testAddBalanceRequest")
    @Test
    public void testAddBalanceRequest(){
        this.statisticsService.addBalanceRequest();

        Mockito.verify(mockStatisticsRepository).addBalanceRequest();
        Mockito.verifyNoMoreInteractions(mockStatisticsRepository);
    }

    @DisplayName("Test - StatisticsServiceImplTest - testAddWithdrawal")
    @Test
    public void testAddWithdrawal(){
        this.statisticsService.addWithdrawal(3d);

        Mockito.verify(mockStatisticsRepository).addWithdrawal(eq(3d));
        Mockito.verifyNoMoreInteractions(mockStatisticsRepository);
    }

    @DisplayName("Test - StatisticsServiceImplTest - testAddWithdrawalSuccessful")
    @Test
    public void testAddWithdrawalSuccessful(){
        this.statisticsService.addWithdrawalSuccessful(4d);

        Mockito.verify(mockStatisticsRepository).addWithdrawalSuccessful(eq(4d));
        Mockito.verifyNoMoreInteractions(mockStatisticsRepository);
    }

    @DisplayName("Test - StatisticsServiceImplTest - testAddWithdrawalFailure")
    @Test
    public void testAddWithdrawalFailure(){
        this.statisticsService.addWithdrawalFailure(5d);

        Mockito.verify(mockStatisticsRepository).addWithdrawalFailure(eq(5d));
        Mockito.verifyNoMoreInteractions(mockStatisticsRepository);
    }

    @DisplayName("Test - StatisticsServiceImplTest - testGetAllStatistics")
    @Test
    public void testGetAllStatistics(){
        this.statisticsService.getAllStatistics();

        Mockito.verify(this.mockStatisticsRepository).getAllStatistics();
        Mockito.verifyNoMoreInteractions(mockStatisticsRepository);
    }
}
