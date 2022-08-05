package com.zinworks.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class AccountTest {

    @DisplayName("Test - AccountTest - testConstructor")
    @Test
    public void testConstructor() {
        Account account = new Account("accountNumber", "pin", 30);

        assertEquals("accountNumber", account.getAccountNumber());
        assertEquals("pin", account.getPin());
        assertEquals(30d, account.getBalance());
    }

    @DisplayName("Test - AccountTest - testData_EqualsAndHashCode")
    @Test
    public void testData_EqualsAndHashCode(){
        Account account = new Account("accountNumber", "pin", 30);

        assertEquals(account, account);
        assertEquals(account.hashCode(), account.hashCode());

        Account account2 = new Account("accountNumber2", "pin2", 302);

        assertNotEquals(account, account2);
        assertNotEquals(account.hashCode(), account2.hashCode());
    }

    @DisplayName("Test - AccountTest - testData_GettersAndSetters")
    @Test
    public void testData_GettersAndSetters(){
        Account account = new Account("accountNumber", "pin", 30);

        assertEquals("accountNumber", account.getAccountNumber());
        assertEquals("pin", account.getPin());
        assertEquals(30d, account.getBalance());

        account.setAccountNumber("newAccountNumber");
        account.setPin("newPin");
        account.setBalance(9d);

        assertEquals("newAccountNumber", account.getAccountNumber());
        assertEquals("newPin", account.getPin());
        assertEquals(9d, account.getBalance());
    }

}
