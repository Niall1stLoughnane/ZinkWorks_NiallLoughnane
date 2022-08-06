package com.zinkworks.exceptions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DispenseNotAllowedExeptionTest{

    @DisplayName("Test - nnnnfx - testException")
    @Test
    public void testException() {
        DispenseNotAllowedExeption accountNotExistExeption = new DispenseNotAllowedExeption("message", System.currentTimeMillis());

        assertEquals("message", accountNotExistExeption.getMessage());
        assertNull(accountNotExistExeption.getCause());
        assertNotNull(accountNotExistExeption.getSystemTime());
    }
}
