package com.zinkworks.exceptions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerInvalidExceptionTest {

    @DisplayName("Test - CustomerInvalidExceptionTest - testException")
    @Test
    public void testException() {
        CustomerInvalidException accountNotExistExeption = new CustomerInvalidException("message", System.currentTimeMillis());

        assertEquals("message", accountNotExistExeption.getMessage());
        assertNull(accountNotExistExeption.getCause());
        assertNotNull(accountNotExistExeption.getSystemTime());
    }
}
