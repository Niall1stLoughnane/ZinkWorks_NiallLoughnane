package com.zinkworks.controller;

import com.zinkworks.model.Statistics;
import com.zinkworks.service.StatisticsService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
public class StatisticsControllerTest {

    @InjectMocks
    private StatisticsController statisticsController;

    @Mock
    private StatisticsService mockStatisticsService;

    @Test
    public void testGetStatistics() {
        Statistics mockStatistics = mock(Statistics.class);
        Mockito.when(mockStatisticsService.getAllStatistics()).thenReturn(mockStatistics);

        Statistics result = statisticsController.getStatistics();

        assertEquals(mockStatistics, result);
        Mockito.verify(mockStatisticsService).getAllStatistics();
        Mockito.verifyNoMoreInteractions(mockStatistics, mockStatisticsService);
    }

}
