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
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;

public class CustomerControllerTest {

    @InjectMocks
    private CustomerController customerController;

    @Mock
    private CustomerService mockCustomerService;

    @Mock
    private BalanceService mockBalanceService;

    @Mock
    private DispenseServiceImpl mockDispenseService;

    @Test
    public void testGetBalance() throws CustomerInvalidException, AccountNotValidatedException {
        Balance balance = new Balance(1, 2d, 3d);
        Mockito.when(mockBalanceService.getBalanceDetails(1, 2)).thenReturn(balance);

        Balance result = customerController.getBalance(1, 2);

        assertEquals(balance, result);
        Mockito.verify(mockBalanceService).getBalanceDetails(eq(1), eq(2));
        Mockito.verifyNoMoreInteractions(mockBalanceService, mockDispenseService);
    }
    @Test
    public void testGetBalanceWhenExceptionsAreThrown() throws CustomerInvalidException, AccountNotValidatedException {
        Mockito.when(mockBalanceService.getBalanceDetails(1, 2)).thenThrow(CustomerInvalidException.class);

        customerController.getBalance(1, 2);
    }
    @Test
    public void testDispenseAccount() throws ZinWorksException {
        CustomerAccount mockCustomerAccount = Mockito.mock(CustomerAccount.class);
        DispensedAmount dispensedAmount = new DispensedAmount(1d, mockCustomerAccount);
        Mockito.when(mockDispenseService.dispense(eq(1), eq(2), eq(3d))).thenReturn(dispensedAmount);

        DispensedAmount result = customerController.dispenseAccount(1, 2, 3);

        assertEquals(dispensedAmount, result);
        Mockito.verify(mockBalanceService).getBalanceDetails(eq(1), eq(2));
        Mockito.verifyNoMoreInteractions(mockBalanceService, mockDispenseService);
    }
    @Test
    public void testDispenseAccountWenExceptionsAreThrown() throws ZinWorksException {
        Mockito.when(mockDispenseService.dispense(eq(1), eq(2), eq(3d))).thenThrow(new CustomerInvalidException("message", 1l));

        customerController.dispenseAccount(1, 2, 3);
    }
}
