package com.zinkworks.service;

import com.zinkworks.exceptions.InvalidReequestAmountException;
import com.zinkworks.model.CustomerAccount;
import com.zinkworks.repository.CustomerAccountRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class DispenseServiceImplTest {

    @InjectMocks
    private DispenseServiceImpl dispenseService;

    @Mock
    private CustomerAccountRepository mockCustomerAccountRepository;

    @Mock
    private AtmServiceImpl mockAtmService;

    @DisplayName("Test - DispenseServiceImplTest - testDispenseWhenDispenseAmountIsGreaterThanAtmBalance")
    @Test
    public void testDispense() throws InvalidReequestAmountException {
        CustomerAccount mockCustomerAccount = Mockito.mock(CustomerAccount.class);
        Mockito.when(mockCustomerAccount.getBalance()).thenReturn(2000d);
        Mockito.when(mockCustomerAccountRepository.getCustomerAccount(1, 2)).thenReturn(mockCustomerAccount);
        Mockito.when(mockAtmService.getBalance()).thenReturn(2000d);

        dispenseService.dispense(1,2, 300d);

        Mockito.verify(mockCustomerAccount,Mockito.times(3)).getBalance();
        Mockito.verify(mockCustomerAccountRepository).getCustomerAccount(1, 2);
        Mockito.verify(mockAtmService).getBalance();
        Mockito.verify(mockAtmService).updateAtm(Mockito.eq(300d));
        Mockito.verify(mockCustomerAccountRepository).withDrawAmount(Mockito.eq(mockCustomerAccount), Mockito.eq(300d));
        Mockito.verify(mockCustomerAccount).getOverDraft();
        Mockito.verifyNoMoreInteractions(mockCustomerAccountRepository, mockAtmService, mockCustomerAccount);
    }

    @DisplayName("Test - DispenseServiceImplTest - testDispenseWhenDispenseAmountIsGreaterThanAtmBalance")
    @Test
    public void testDispenseWhenDispenseAmountIsGreaterThanAtmBalance() throws InvalidReequestAmountException {
        CustomerAccount mockCustomerAccount = Mockito.mock(CustomerAccount.class);
        Mockito.when(mockCustomerAccount.getBalance()).thenReturn(2000d);
        Mockito.when(mockCustomerAccountRepository.getCustomerAccount(1, 2)).thenReturn(mockCustomerAccount);
        Mockito.when(mockAtmService.getBalance()).thenReturn(1d);

        try {
            dispenseService.dispense(1, 2, 300d);
        }catch (InvalidReequestAmountException e){
            assertEquals("Invalid Request amount", e.getMessage());
        }

        Mockito.verify(mockCustomerAccount).getBalance();
        Mockito.verify(mockCustomerAccountRepository).getCustomerAccount(1, 2);
        Mockito.verify(mockAtmService).getBalance();
        Mockito.verifyNoMoreInteractions(mockCustomerAccountRepository, mockAtmService, mockCustomerAccount);
    }

}
