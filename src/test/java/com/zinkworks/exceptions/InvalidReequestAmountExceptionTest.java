package com.zinkworks.exceptions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class InvalidReequestAmountExceptionTest {

    @DisplayName("Test - InvalidReequestAmountExceptionTest - testException")
    @Test
    public void testException() {
        InvalidReequestAmountException accountNotExistExeption = new InvalidReequestAmountException("message", System.currentTimeMillis());

        assertEquals("message", accountNotExistExeption.getMessage());
        assertNull(accountNotExistExeption.getCause());
        assertNotNull(accountNotExistExeption.getSystemTime());
    }
}
