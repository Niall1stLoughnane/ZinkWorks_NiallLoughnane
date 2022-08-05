package com.zinworks.service;

import com.zinworks.exceptions.ZinWorksExeption;
import com.zinworks.model.Account;
import com.zinworks.model.User;
import com.zinworks.repository.UserAccountRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AccountServiceTest {

    @InjectMocks
    private AccountServiceImpl accountService= new AccountServiceImpl();

    @Mock
    private UserAccountRepository userAccountRepository = new UserAccountRepository();

    @Mock
    private AtmServiceImpl atmService = new AtmServiceImpl();

    @DisplayName("Test - AccountServiceTest - getAccountDetails")
    @Test
    void testGetAccountDetails() throws ZinWorksExeption {
        Account mockAccount = Mockito.mock(Account.class);
        when(userAccountRepository.getAccount(anyString(), anyString(), eq(true))).thenReturn(mockAccount);
        when(mockAccount.getBalance()).thenReturn(30d);
        when(atmService.getTotalAllowedDispenseAmount(eq(30d))).thenReturn(90d);

        User result = accountService.getAccountDetails("accountNumber", "pin");

        assertEquals("accountNumber", result.getAccountNumber());
        assertEquals(90d, result.getAllowedWithdrawalAmount());
        assertEquals(30d, result.getBalance());
        Mockito.verify(userAccountRepository).getAccount(anyString(), anyString(), eq(true));
        Mockito.verify(atmService).getTotalAllowedDispenseAmount(eq(30d));
        verifyNoMoreInteractions(userAccountRepository, mockAccount, atmService);
    }

}
