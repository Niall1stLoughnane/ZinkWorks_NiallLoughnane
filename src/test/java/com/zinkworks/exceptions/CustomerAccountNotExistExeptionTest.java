package com.zinkworks.exceptions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerAccountNotExistExeptionTest {

    @DisplayName("Test - CustomerAccountNotExistExeptionTest - testException")
    @Test
    public void testException() {
        AccountNotExistExeption accountNotExistExeption = new AccountNotExistExeption("message", System.currentTimeMillis());

        assertEquals("message", accountNotExistExeption.getMessage());
        assertNull(accountNotExistExeption.getCause());
        assertNotNull(accountNotExistExeption.getSystemTime());
    }
}
