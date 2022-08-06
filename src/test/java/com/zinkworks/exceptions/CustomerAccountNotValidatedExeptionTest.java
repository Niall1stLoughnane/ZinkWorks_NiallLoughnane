package com.zinkworks.exceptions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerAccountNotValidatedExeptionTest {

    @DisplayName("Test - CustomerAccountNotValidatedExeptionTest - testException")
    @Test
    public void testException() {
        AccountNotValidatedExeption accountNotValidatedExeption = new AccountNotValidatedExeption("message", System.currentTimeMillis());

        assertEquals("message", accountNotValidatedExeption.getMessage());
        assertNull(accountNotValidatedExeption.getCause());
        assertNotNull(accountNotValidatedExeption.getSystemTime());
    }
}