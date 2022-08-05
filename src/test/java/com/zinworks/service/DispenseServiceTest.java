package com.zinworks.service;

import com.zinworks.exceptions.ZinWorksExeption;
import com.zinworks.model.Account;
import com.zinworks.model.DispensedAmount;
import com.zinworks.repository.UserAccountRepository;
import com.zinworks.validation.UserAccountValidator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DispenseServiceTest {

    @InjectMocks
    private DispenseService dispenseService;

    @Mock
    private UserAccountRepository userAccountRepository;

    @Mock
    private AtmService atmService = new AtmService();

    @Mock
    private UserAccountValidator userAccountValidator = new UserAccountValidator();

    @Test
    public void testDispense() throws ZinWorksExeption {
        Account mockAccount = Mockito.mock(Account.class);
        when(mockAccount.getBalance()).thenReturn(90d);
        when(userAccountRepository.getAccount(eq("accountNumber"), eq("pin"), eq(true))).thenReturn(mockAccount);
        when(atmService.getTotalAllowedDispenseAmount(90)).thenReturn(33d);
        userAccountRepository.updateAccount(eq(mockAccount));

        DispensedAmount result = dispenseService.dispense("accountNumber", "pin", 30d);

        assertEquals(23, result);
        verify(atmService).updateAtm(eq(92));
        verify(mockAccount).setBalance(98d);
    }

}
