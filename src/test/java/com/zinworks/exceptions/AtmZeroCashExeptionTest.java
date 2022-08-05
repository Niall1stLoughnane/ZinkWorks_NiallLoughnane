package com.zinworks.exceptions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AtmZeroCashExeptionTest {

    @DisplayName("Test - AccountNotExistExeptionTest - testException")
    @Test
    public void testException() {
        AtmZeroCashExeption atmZeroCashExeption = new AtmZeroCashExeption("message", System.currentTimeMillis());

        assertEquals("message", atmZeroCashExeption.getMessage());
        assertNull(atmZeroCashExeption.getCause());
        assertNotNull(atmZeroCashExeption.getSystemTime());
    }
}
