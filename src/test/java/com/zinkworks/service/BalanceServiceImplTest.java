package com.zinkworks.service;

import com.zinkworks.model.CustomerAccount;
import com.zinkworks.repository.CustomerAccountRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import static org.mockito.ArgumentMatchers.eq;

public class BalanceServiceImplTest {

    private BalanceServiceImpl balanceService;

    @Mock
    private CustomerAccountRepository mockCustomerAccountRepository;

    @Mock
    private AtmServiceImpl mockAtmServiceImpl;

    @Test
    public void testGetBalanceDetails(){
/*
//        CustomerAccount mockCustomerAccount = Mockito.mock(CustomerAccount.class);
//        Mockito.mock((mockCustomerAccount.getBalance()))

        Mockito.when(mockCustomerAccountRepository.getCustomerAccount(1, 2)).thenReturn(mockCustomerAccount);
*/

    }
}
