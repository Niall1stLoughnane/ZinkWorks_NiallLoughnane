package com.zinworks.controller;

import com.zinworks.exceptions.ZinWorksExeption;
import com.zinworks.model.DispensedAmount;
import com.zinworks.service.DispenseServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.zip.ZipException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DispenseControllerTest {

    @InjectMocks
    private DispenseController dispenseController = new DispenseController();

    @Mock
    private DispenseServiceImpl dispenseService;

    @DisplayName("Test - DispenseControllerTest - dispenseAccount")
    @Test
    void testDispenseAccount() throws ZinWorksExeption, ZipException {
        DispensedAmount mockDispensedAmount = Mockito.mock(DispensedAmount.class);
        when(dispenseService.dispense(eq("accountNumber"), anyString(), anyDouble())).thenReturn(mockDispensedAmount);

        DispensedAmount result = dispenseController.dispenseAccount("accountNumber", "pin", 50d);

        assertEquals(mockDispensedAmount, result);
        verify(dispenseService).dispense(anyString(), anyString(), anyDouble());
        verifyNoMoreInteractions(dispenseService);
        verifyNoInteractions(mockDispensedAmount);
    }

}
