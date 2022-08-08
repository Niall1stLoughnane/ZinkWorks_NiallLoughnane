package com.zinkworks.service;

import com.zinkworks.model.Notes;
import com.zinkworks.repository.AtmRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class AtmServiceImplTest {

    @InjectMocks
    private AtmServiceImpl atmService;

    @Mock
    private AtmRepository mockAtmRepository;

    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @DisplayName("Test - AtmServiceImplTest - testUpdateAtm")
    @Test
    public void testUpdateAtm(){
        Mockito.when(mockAtmRepository.getBalance()).thenReturn(50d);

        atmService.updateAtm(1d);

        Mockito.verify(mockAtmRepository).updateBalanceAndNotes(Mockito.eq(49d), Mockito.any(Notes.class));
        Mockito.verifyNoMoreInteractions(mockAtmRepository);
    }

    @DisplayName("Test - AtmServiceImplTest - testGetBalance")
    @Test
    public void testGetBalance(){
        Mockito.when(mockAtmRepository.getBalance()).thenReturn(100d);

        Double result = atmService.getBalance();

        assertEquals(100d, result);
        Mockito.verify(mockAtmRepository).getBalance();
    }

}
