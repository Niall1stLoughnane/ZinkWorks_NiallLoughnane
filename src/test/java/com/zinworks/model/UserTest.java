package com.zinworks.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class UserTest {

    @DisplayName("Test - UserTest - testConstructor")
    @Test
    public void testConstructor() {
        User user = new User("accountNumber", 9d, 7d);

        assertEquals("accountNumber", user.getAccountNumber());
        assertEquals(9d, user.getBalance());
        assertEquals(7d, user.getAllowedWithdrawalAmount());
    }

    @DisplayName("Test - UserTest - testData_EqualsAndHashCode")
    @Test
    public void testData_EqualsAndHashCode(){
        User user = new User("accountNumber", 9d, 7d);

        assertEquals(user, user);
        assertEquals(user.hashCode(), user.hashCode());

        User user2 = new User("accountNumber2", 92d, 72d);

        assertNotEquals(user, user2);
        assertNotEquals(user.hashCode(), user2.hashCode());
    }

    @DisplayName("Test - UserTest - testData_GettersAndSetters")
    @Test
    public void testData_GettersAndSetters(){
        User user = new User("accountNumber", 9d, 7d);

        assertEquals("accountNumber", user.getAccountNumber());
        assertEquals(9d, user.getBalance());
        assertEquals(7d, user.getAllowedWithdrawalAmount());

        user.setAccountNumber("newAccountNumber");
        user.setAllowedWithdrawalAmount(44);
        user.setBalance(33);

        assertEquals("newAccountNumber", user.getAccountNumber());
        assertEquals(33, user.getBalance());
        assertEquals(44, user.getAllowedWithdrawalAmount());
    }
}
