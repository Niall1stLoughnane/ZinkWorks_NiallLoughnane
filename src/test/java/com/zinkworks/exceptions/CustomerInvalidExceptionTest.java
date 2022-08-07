package com.zinkworks.exceptions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerInvalidExceptionTest {

    @DisplayName("Test - AccountNotValidatedExceptionTest - testException")
    @Test
    public void testException() {
        CustomerInvalidException customerInvalidException = new CustomerInvalidException("message", System.currentTimeMillis());

        assertEquals("message", customerInvalidException.getMessage());
        assertNull(customerInvalidException.getCause());
        assertNotNull(customerInvalidException.getSystemTime());
    }

}
