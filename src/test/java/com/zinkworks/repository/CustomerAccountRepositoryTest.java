package com.zinkworks.repository;

import com.zinkworks.model.CustomerAccount;
import com.zinkworks.service.AtmService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerAccountRepositoryTest {

    private CustomerAccountRepository customerAccountRepository;

    @BeforeEach
    public void doSetup(){
        customerAccountRepository = new CustomerAccountRepository();
        customerAccountRepository.initialize();
    }

    @Test
    public void testGetCustomerAccount(){

        CustomerAccount customerAccount123456789 = customerAccountRepository.getCustomerAccount(123456789, 1234);
        assertEquals("123456789_1234", customerAccount123456789.getAccountNumber());
        assertEquals(1234, customerAccount123456789.getPin());
        assertEquals(800d, customerAccount123456789.getBalance());
        assertEquals(200, customerAccount123456789.getOverDraft());

        CustomerAccount customerAccount987654321 = customerAccountRepository.getCustomerAccount(987654321, 4321);
        assertEquals("987654321_4321", customerAccount987654321.getAccountNumber());
        assertEquals(4321, customerAccount987654321.getPin());
        assertEquals(1230d, customerAccount987654321.getBalance());
        assertEquals(150, customerAccount987654321.getOverDraft());
    }

    @Test
    public void testWithDrawAmountWhenCustomerAccountBalanceIsLessThanWithDrawAmount(){
        CustomerAccount mockCustomerAccount = Mockito.mock(CustomerAccount.class);
        Mockito.when(mockCustomerAccount.getBalance()).thenReturn(2d);
        Mockito.when(mockCustomerAccount.getAccountNumber()).thenReturn("123456789_1234");

        customerAccountRepository.withDrawAmount(mockCustomerAccount, 10d);

        Mockito.verify(mockCustomerAccount).setOverDraft(8d);
        Mockito.verify(mockCustomerAccount).setBalance(0d);
        Mockito.verify(mockCustomerAccount, Mockito.times(2)).getBalance();
        Mockito.verify(mockCustomerAccount).getAccountNumber();
        Mockito.verifyNoMoreInteractions(mockCustomerAccount);
    }

    @Test
    public void testWithDrawAmountWhenCustomerAccountBalanceIsGreaterThanWithDrawAmount(){
        CustomerAccount mockCustomerAccount = Mockito.mock(CustomerAccount.class);
        Mockito.when(mockCustomerAccount.getBalance()).thenReturn(200d);
        Mockito.when(mockCustomerAccount.getAccountNumber()).thenReturn("123456789_1234");

        customerAccountRepository.withDrawAmount(mockCustomerAccount, 10d);

        Mockito.verify(mockCustomerAccount,Mockito.times(1)).setBalance(190.0d);
        Mockito.verify(mockCustomerAccount, Mockito.times(2)).getBalance();
        Mockito.verify(mockCustomerAccount).getAccountNumber();
        Mockito.verifyNoMoreInteractions(mockCustomerAccount);
    }
}
