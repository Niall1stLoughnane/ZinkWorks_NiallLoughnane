package com.zinworks.exceptions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ZinWorksExeptionTest {

    @DisplayName("Test - ZinWorksExeptionTest - testException")
    @Test
    public void testException() {
        ZinWorksExeption zinWorksExeption = new ZinWorksExeption("message");

        assertEquals("message", zinWorksExeption.getMessage());
        assertNull(zinWorksExeption.getCause());
    }
}
