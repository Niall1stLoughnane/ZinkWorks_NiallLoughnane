package com.zinkworks.service;

import com.zinkworks.model.Balance;
import com.zinkworks.model.CustomerAccount;
import com.zinkworks.repository.CustomerAccountRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;

@ExtendWith(MockitoExtension.class)
public class BalanceServiceImplTest {

    @InjectMocks
    private BalanceServiceImpl balanceService;

    @Mock
    private CustomerAccountRepository mockCustomerAccountRepository;

    @Mock
    private AtmServiceImpl mockAtmService;

    @Test
    public void testGetBalanceDetails(){
        CustomerAccount mockCustomerAccount = Mockito.mock(CustomerAccount.class);
        Mockito.when(mockCustomerAccount.getBalance()).thenReturn(2d);
        Mockito.when(mockCustomerAccount.getOverDraft()).thenReturn(2d);
        Mockito.when(mockCustomerAccountRepository.getCustomerAccount(1, 2)).thenReturn(mockCustomerAccount);

        Balance result = balanceService.getBalanceDetails(1, 2);

        assertEquals(2, result.getBalance());
        assertEquals(1, result.getAccountNumber());
        assertEquals(4, result.getMaximumWithdrawlAmount());
        Mockito.verify(mockCustomerAccount, Mockito.times(2)).getBalance();
        Mockito.verify(mockCustomerAccount).getOverDraft();
        Mockito.verify(mockCustomerAccountRepository).getCustomerAccount(eq(1), eq(2));
        Mockito.verifyNoMoreInteractions(mockCustomerAccount, mockCustomerAccountRepository);
    }
}
