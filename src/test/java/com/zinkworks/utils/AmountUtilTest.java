package com.zinkworks.utils;

import com.zinkworks.exceptions.InvalidReequestAmountException;
import com.zinkworks.model.Account;
import com.zinkworks.model.CustomerAccount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

public class AmountUtilTest {

    @DisplayName("Test - AmountUtilTest - testAmountUtilWhenAccountBalanceIsLessThanAmountRequested")
    @Test
    public void testAmountUtilWhenAccountBalanceIsLessThanAmountRequested() throws InvalidReequestAmountException {
        CustomerAccount mockCustomerAccount = Mockito.mock(CustomerAccount.class);
        Mockito.when(mockCustomerAccount.getBalance()).thenReturn(10d);

        double result = AmountUtil.getDispenseAmount(mockCustomerAccount, 90);

        assertEquals(10, result);
        verify(mockCustomerAccount).getBalance();
        verifyNoMoreInteractions(mockCustomerAccount);
    }

}
