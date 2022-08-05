package com.zinworks.model;

import org.assertj.core.error.future.Warning;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountTest {

    @Test
    public void testConstructor() {
        Account account = new Account("accountNumber", "pin", 30);

        assertEquals("accountNumber", account.getAccountNumber());
        assertEquals("pin", account.getPin());
        assertEquals(30d, account.getBalance());
    }
}
