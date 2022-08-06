package com.zinkworks.service;

import com.zinworks.exceptions.ZinWorksExeption;
import com.zinworks.model.Notes;
import com.zinworks.repository.AtmRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@SuppressWarnings("ResultOfMethodCallIgnored")
@ExtendWith(MockitoExtension.class)
public class AtmServiceTest {

    @InjectMocks
    private AtmServiceImpl atmService = new AtmServiceImpl();

    @Mock
    private AtmRepository atmRepository = new AtmRepository();

    @DisplayName("Test - AtmServiceTest - testGetTotalAllowedDispenseAmountWhenBalanceIsLessThanAmount")
    @Test
    void testGetTotalAllowedDispenseAmountWhenBalanceIsLessThanAmount() throws ZinWorksExeption {
        when(atmRepository.getBalance()).thenReturn(90d);

        double result = atmService.getTotalAllowedDispenseAmount(10);

        assertEquals(10, result);
        verify(atmRepository).getBalance();
        verifyNoMoreInteractions(atmRepository);
    }

    @DisplayName("Test - AtmServiceTest - testGetTotalAllowedDispenseAmountWhenBalanceIsGreaterThanAmount")
    @Test
    void testGetTotalAllowedDispenseAmountWhenBalanceIsGreaterThanAmount() throws ZinWorksExeption {
        when(atmRepository.getBalance()).thenReturn(90d);

        double result = atmService.getTotalAllowedDispenseAmount(10);

        assertEquals(10, result);
        verify(atmRepository).getBalance();
        verifyNoMoreInteractions(atmRepository);
    }

    @DisplayName("Test - AtmServiceTest - testGetTotalAllowedDispenseAmountWhenBalanceIsEqualsThanAmount")
    @Test
    void testGetTotalAllowedDispenseAmountWhenBalanceIsEqualsThanAmount() throws ZinWorksExeption {
        when(atmRepository.getBalance()).thenReturn(90d);

        double result = atmService.getTotalAllowedDispenseAmount(10);

        assertEquals(10, result);
        verify(atmRepository).getBalance();
        verifyNoMoreInteractions(atmRepository);
    }

    @DisplayName("Test - AtmServiceTest - testGetTotalAllowedDispenseAmountWhenBalanceIsLessThan0")
    @Test
    void testGetTotalAllowedDispenseAmountWhenBalanceIsLessThan0() throws ZinWorksExeption {
        when(atmRepository.getBalance()).thenReturn(-1d);

        try {
            atmService.getTotalAllowedDispenseAmount(10);
        } catch (ZinWorksExeption e) {
            assertEquals("Not enough money in ATM", e.getMessage());
        }

        verify(atmRepository).getBalance();
        verifyNoMoreInteractions(atmRepository);
    }

    @DisplayName("Test - AtmServiceTest - testGetTotalAllowedDispenseAmountWhenBalanceIsZero")
    @Test
    void testGetTotalAllowedDispenseAmountWhenBalanceIsZero() throws ZinWorksExeption {
        when(atmRepository.getBalance()).thenReturn(0d);

        double result = atmService.getTotalAllowedDispenseAmount(10);

        assertEquals(0, result);
        verify(atmRepository).getBalance();
        verifyNoMoreInteractions(atmRepository);
    }

    @DisplayName("Test - AtmServiceTest - testUpdateAtm")
    @Test
    public void testUpdateAtm() {
        when(atmRepository.getBalance()).thenReturn(1500d);

        atmService.updateAtm(1285d);

        ArgumentCaptor<Notes> notesCaptor = ArgumentCaptor.forClass(Notes.class);
        verify(atmRepository).updateBalanceAndNotes(eq(215d), notesCaptor.capture());
        Notes notes = notesCaptor.getValue();
        assertEquals(25, notes.getQuantity50());
        assertEquals(1, notes.getQuantity20());
        assertEquals(1, notes.getQuantity10());
        assertEquals(1, notes.getQuantity5());
        verifyNoMoreInteractions(atmRepository);
    }

}
