package com.zinkworks.service;

import com.zinkworks.model.Balance;
import com.zinkworks.model.CustomerAccount;
import com.zinkworks.repository.CustomerAccountRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;

public class BalanceServiceImplTest {

    @InjectMocks
    private BalanceServiceImpl balanceService;

    @Mock
    private CustomerAccountRepository mockCustomerAccountRepository;

    @Mock
    private AtmServiceImpl mockAtmServiceImpl;

    @BeforeEach
    public void doSetup() {
        balanceService = new BalanceServiceImpl();
        mockCustomerAccountRepository = Mockito.mock(CustomerAccountRepository.class);
        mockAtmServiceImpl = Mockito.mock(AtmServiceImpl.class);
    }

/*
    @Test
    public void testGetBalanceDetails(){
        CustomerAccount mockCustomerAccount = Mockito.mock(CustomerAccount.class);
        Mockito.when(mockCustomerAccount.getBalance()).thenReturn(2d);
        Mockito.when(mockCustomerAccount.getOverDraft()).thenReturn(2d);
        Mockito.when(mockCustomerAccountRepository.getCustomerAccount(1, 2)).thenReturn(mockCustomerAccount);

        Balance result = balanceService.getBalanceDetails(1, 2);

        assertEquals(3, result.getBalance());
        assertEquals(3, result.getAccountNumber());
        assertEquals(3, result.getMaximumWithdrawlAmount());
        Mockito.verify(mockCustomerAccount).getBalance();
        Mockito.verify(mockCustomerAccount).getOverDraft();
        Mockito.verify(mockCustomerAccountRepository).getCustomerAccount(eq(1), eq(2));
        Mockito.verifyNoMoreInteractions(mockCustomerAccount, mockCustomerAccountRepository);
    }
*/
}
