package com.zinkworks.exceptions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ZinWorksExceptionTest {

    @DisplayName("Test - ZinWorksExceptionTest - testException")
    @Test
    public void testException() {
        ZinWorksException zinWorksException = new AccountNotValidatedException("message", System.currentTimeMillis());

        assertEquals("message", zinWorksException.getMessage());
        assertNull(zinWorksException.getCause());
        assertNotNull(zinWorksException.getSystemTime());
    }
}
