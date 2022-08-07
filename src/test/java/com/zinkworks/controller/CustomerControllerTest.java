package com.zinkworks.controller;

import com.zinkworks.exceptions.AccountNotValidatedException;
import com.zinkworks.exceptions.CustomerInvalidException;
import com.zinkworks.exceptions.ZinWorksException;
import com.zinkworks.model.Balance;
import com.zinkworks.model.CustomerAccount;
import com.zinkworks.model.DispensedAmount;
import com.zinkworks.service.BalanceService;
import com.zinkworks.service.CustomerService;
import com.zinkworks.service.DispenseServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class CustomerControllerTest {

    @InjectMocks
    private CustomerController customerController;

    @Mock
    private CustomerService mockCustomerService;

    @Mock
    private BalanceService mockBalanceService;

    @Mock
    private DispenseServiceImpl mockDispenseService;

    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public  void testGetBalance() throws CustomerInvalidException, AccountNotValidatedException {
        Balance balance = new Balance(1, 2d, 3d);
        Mockito.when(mockBalanceService.getBalanceDetails(Mockito.eq(1), Mockito.eq(2))).thenReturn(balance);

        Balance result = customerController.getBalance(1, 2);

        assertEquals(balance, result);
        Mockito.verify(mockBalanceService).getBalanceDetails(Mockito.eq(1), Mockito.eq(2));
        Mockito.verify(mockCustomerService).isValidCustomer(Mockito.eq(1), Mockito.eq(2));
        Mockito.verifyNoMoreInteractions(mockCustomerService, mockBalanceService, mockDispenseService);
    }

    @Test
    public void testDispenseAccount() throws ZinWorksException {
        CustomerAccount mockCustomerAccount = Mockito.mock(CustomerAccount.class);
        DispensedAmount dispensedAmount = new DispensedAmount(1d, mockCustomerAccount);
        Mockito.when(mockDispenseService.dispense(1, 2, 3d)).thenReturn(dispensedAmount);

        DispensedAmount result = customerController.dispenseAccount(1, 2, 3d);

        assertEquals(dispensedAmount, result);
        Mockito.verify(mockCustomerAccount, Mockito.times(2)). getBalance();
        Mockito.verify(mockCustomerAccount). getOverDraft();
        Mockito.verify(mockDispenseService).dispense(Mockito.eq(1), Mockito.eq(2), Mockito.eq(3d));
        Mockito.verify(mockCustomerService).isValidCustomer(Mockito.eq(1), Mockito.eq(2));
        Mockito.verifyNoMoreInteractions(mockCustomerAccount, mockCustomerService, mockDispenseService, mockBalanceService);
    }
}
