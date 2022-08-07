package com.zinkworks.service;

import com.zinkworks.model.CustomerAccount;
import com.zinkworks.repository.CustomerAccountRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

@ExtendWith(MockitoExtension.class)
public class DispenseServiceImplTest {

    @InjectMocks
    private DispenseServiceImpl dispenseService;

    @Mock
    private CustomerAccountRepository mockCustomerAccountRepository;

    @Mock
    private AtmServiceImpl mockAtmService;

    @Test
    public void testDispense(){
        CustomerAccount mockCustomerAccount = Mockito.mock(CustomerAccount.class);
        Mockito.when(mockCustomerAccountRepository.getCustomerAccount(1, 1)).thenReturn(Mockito.any(CustomerAccount.class));

    }

}
