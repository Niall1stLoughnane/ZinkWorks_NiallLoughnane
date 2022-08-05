package com.zinworks.exceptions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DispenseNotAllowedExeptionTest {

    @DisplayName("Test - AccountNotExistExeptionTest - testException")
    @Test
    public void testException() {
        DispenseNotAllowedExeption dispenseNotAllowedExeption = new DispenseNotAllowedExeption("message", System.currentTimeMillis());

        assertEquals("message", dispenseNotAllowedExeption.getMessage());
        assertNull(dispenseNotAllowedExeption.getCause());
        assertNotNull(dispenseNotAllowedExeption.getSystemTime());
    }
}
