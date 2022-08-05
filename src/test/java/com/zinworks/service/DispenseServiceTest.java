package com.zinworks.service;

import com.zinworks.exceptions.ZinWorksExeption;
import com.zinworks.model.Account;
import com.zinworks.model.DispensedAmount;
import com.zinworks.repository.UserAccountRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DispenseServiceTest {

    @InjectMocks
    private DispenseService dispenseService;

    @Mock
    private UserAccountRepository userAccountRepository;

    @Mock
    private AtmService atmService = new AtmService();

    @Test
    public void testDispense() throws ZinWorksExeption {
        Account mockAccount = Mockito.mock(Account.class);
        when(mockAccount.getBalance()).thenReturn(90d);
        when(mockAccount.getPin()).thenReturn("pin");
        when(userAccountRepository.getAccount(eq("accountNumber"), eq("pin"), eq(true))).thenReturn(mockAccount);
        when(atmService.getTotalAllowedDispenseAmount(30d)).thenReturn(33d);

        DispensedAmount result = dispenseService.dispense("accountNumber", "pin", 30d);

        assertEquals(33, result.getDispensedAmount());
        verify(atmService).getTotalAllowedDispenseAmount(eq(30d));
        verify(atmService).updateAtm(eq(33d));
        verify(mockAccount).setBalance(57d);
        ArgumentCaptor<Account> accountCaptor = ArgumentCaptor.forClass(Account.class);
        verify(userAccountRepository).updateAccount(accountCaptor.capture());
        assertEquals(90, accountCaptor.getValue().getBalance());
        verifyNoMoreInteractions(userAccountRepository, atmService, userAccountRepository, mockAccount);
    }

    @Test
    public void testDispenseWhenDispenseAmountIsZero() throws ZinWorksExeption {
        Account mockAccount = Mockito.mock(Account.class);
        when(mockAccount.getPin()).thenReturn("pin");
        when(mockAccount.getBalance()).thenReturn(90d);
        when(userAccountRepository.getAccount(eq("accountNumber"), eq("pin"), eq(true))).thenReturn(mockAccount);
        when(atmService.getTotalAllowedDispenseAmount(30d)).thenReturn(0d);

        try {
            dispenseService.dispense("accountNumber", "pin", 30d);
        } catch (ZinWorksExeption e) {
            assertEquals("Dispense not allowed", e.getMessage());
        }

        verify(atmService).getTotalAllowedDispenseAmount(eq(30d));
        verifyNoMoreInteractions(userAccountRepository, atmService, userAccountRepository, mockAccount);
    }

    @Test
    public void testDispenseWhenDispenseAmountIsLessThanZero() throws ZinWorksExeption {
        Account mockAccount = Mockito.mock(Account.class);
        when(mockAccount.getBalance()).thenReturn(90d);
        when(mockAccount.getPin()).thenReturn("pin");
        when(userAccountRepository.getAccount(eq("accountNumber"), eq("pin"), eq(true))).thenReturn(mockAccount);
        when(atmService.getTotalAllowedDispenseAmount(30d)).thenReturn(-3d);

        try {
            dispenseService.dispense("accountNumber", "pin", 30d);
        } catch (ZinWorksExeption e) {
            assertEquals("Dispense not allowed", e.getMessage());
        }

        verify(atmService).getTotalAllowedDispenseAmount(eq(30d));
        verifyNoMoreInteractions(userAccountRepository, atmService, userAccountRepository, mockAccount);
    }

    @Test
    public void testDispenseWhenAccountBalanceIsZero() throws ZinWorksExeption {
        Account mockAccount = Mockito.mock(Account.class);
        when(mockAccount.getBalance()).thenReturn(0d);
        when(mockAccount.getPin()).thenReturn("pin");
        when(userAccountRepository.getAccount(eq("accountNumber"), eq("pin"), eq(true))).thenReturn(mockAccount);

        try {
            dispenseService.dispense("accountNumber", "pin", 30d);
        } catch (ZinWorksExeption e) {
            assertEquals("Dispense not allowed", e.getMessage());
        }

        verifyZeroInteractions(atmService);
        verifyNoMoreInteractions(userAccountRepository, userAccountRepository, mockAccount);
    }

    @Test
    public void testDispenseWhenAccountBalanceIsLessThanDispenseAmount() throws ZinWorksExeption {
        Account mockAccount = Mockito.mock(Account.class);
        when(mockAccount.getBalance()).thenReturn(3d);
        when(mockAccount.getPin()).thenReturn("pin");
        when(userAccountRepository.getAccount(eq("accountNumber"), eq("pin"), eq(true))).thenReturn(mockAccount);
        when(atmService.getTotalAllowedDispenseAmount(3d)).thenReturn(30d);

        try {
            dispenseService.dispense("accountNumber", "pin", 30d);
        } catch (ZinWorksExeption e) {
            assertEquals("Dispense not allowed", e.getMessage());
        }

        verify(atmService).getTotalAllowedDispenseAmount(eq(3d));
        verifyNoMoreInteractions(userAccountRepository, atmService, userAccountRepository, mockAccount);
    }

    @Test
    public void testDispenseWhenAccountBalafnceIsZero() throws ZinWorksExeption {
        Account mockAccount = Mockito.mock(Account.class);
        when(mockAccount.getBalance()).thenReturn(3d);
        when(mockAccount.getPin()).thenReturn("pin");
        when(userAccountRepository.getAccount(eq("accountNumber"), eq("pin"), eq(true))).thenReturn(mockAccount);
        when(atmService.getTotalAllowedDispenseAmount(3d)).thenReturn(30d);

        try {
            dispenseService.dispense("accountNumber", "pin", 30d);
        } catch (ZinWorksExeption e) {
            assertEquals("Dispense not allowed", e.getMessage());
        }

        verify(atmService).getTotalAllowedDispenseAmount(eq(3d));
        verifyNoMoreInteractions(userAccountRepository, atmService, userAccountRepository, mockAccount);
    }

}
