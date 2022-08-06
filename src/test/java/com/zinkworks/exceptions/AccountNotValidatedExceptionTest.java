package com.zinkworks.exceptions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AccountNotValidatedExceptionTest {

    @DisplayName("Test - AccountNotValidatedExceptionTest - testException")
    @Test
    public void testException() {
        AccountNotValidatedException accountNotValidatedException = new AccountNotValidatedException("message", System.currentTimeMillis());

        assertEquals("message", accountNotValidatedException.getMessage());
        assertNull(accountNotValidatedException.getCause());
        assertNotNull(accountNotValidatedException.getSystemTime());
    }
}
