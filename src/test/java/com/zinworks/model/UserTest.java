package com.zinworks.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {

    @Test
    public void test() {
        User user = new User("accountNumber", 9d, 7d);

        assertEquals("accountNumber", user.getAccountNumber());
        assertEquals(9d, user.getBalance());
        assertEquals(7d, user.getAllowedWithdrawalAmount());
    }
}
