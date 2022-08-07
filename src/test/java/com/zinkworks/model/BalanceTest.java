package com.zinkworks.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class BalanceTest {


    @DisplayName("Test - DispensedAmountTest - testConstructor")
    @Test
    public void testConstructor() {
        Balance balance = new Balance(1, 2d, 3d);

        assertEquals(1, balance.getBalance());
        assertEquals(2, balance.getAccountNumber());
        assertEquals(3, balance.getMaximumWithdrawlAmount());
    }

    @DisplayName("Test - DispensedAmountTest - testData_EqualsAndHashCode")
    @Test
    public void testData_EqualsAndHashCode(){
        Balance balance = new Balance(1, 2d, 3d);

        assertEquals(balance, balance);
        assertEquals(balance.hashCode(), balance.hashCode());

        Balance balance2 = new Balance(13, 22d, 33d);

        assertNotEquals(balance, balance2);
        assertNotEquals(balance.hashCode(), balance2.hashCode());
    }

    @DisplayName("Test - DispensedAmountTest - testData_GettersAndSetters")
    @Test
    public void testData_GettersAndSetters(){
        Balance balance = new Balance(1, 2d, 3d);

        assertEquals(2, balance.getBalance());
        assertEquals(1, balance.getAccountNumber());
        assertEquals(3, balance.getMaximumWithdrawlAmount());

        balance.setBalance(33);
        balance.setAccountNumber(12);
        balance.setMaximumWithdrawlAmount(23);

        assertEquals(33, balance.getBalance());
        assertEquals(12, balance.getAccountNumber());
        assertEquals(23, balance.getMaximumWithdrawlAmount());
    }


}
