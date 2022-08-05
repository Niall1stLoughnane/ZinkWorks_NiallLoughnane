package com.zinworks.utils;

import com.zinworks.model.Account;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

public class AmountUtilTest {

    @DisplayName("Test - AmountUtilTest - testAmountUtilWhenAccountBalanceIsLessThanAmountRequested")
    @Test
    public void testAmountUtilWhenAccountBalanceIsLessThanAmountRequested() {
        Account mockAccount = Mockito.mock(Account.class);
        Mockito.when(mockAccount.getBalance()).thenReturn(10d);

        double result = AmountUtil.getDispenseAmount(mockAccount, 90);

        assertEquals(10, result);
        verify(mockAccount).getBalance();
        verifyNoMoreInteractions(mockAccount);
    }

    @DisplayName("Test - AmountUtilTest - testAmountUtilWhenAccountBalanceIsMoreThanAmountRequested")
    @Test
    public void testAmountUtilWhenAccountBalanceIsMoreThanAmountRequested() {
        Account mockAccount = Mockito.mock(Account.class);
        Mockito.when(mockAccount.getBalance()).thenReturn(100d);

        double result = AmountUtil.getDispenseAmount(mockAccount, 90);

        assertEquals(90, result);
        verify(mockAccount).getBalance();
        verifyNoMoreInteractions(mockAccount);
    }

    @DisplayName("Test - AmountUtilTest - testAmountUtilWhenAccountBalanceIsEqualsAmountRequested")
    @Test
    public void testAmountUtilWhenAccountBalanceIsEqualsAmountRequested() {
        Account mockAccount = Mockito.mock(Account.class);
        Mockito.when(mockAccount.getBalance()).thenReturn(90d);

        double result = AmountUtil.getDispenseAmount(mockAccount, 90);

        assertEquals(90, result);
        verify(mockAccount).getBalance();
        verifyNoMoreInteractions(mockAccount);
    }
}
