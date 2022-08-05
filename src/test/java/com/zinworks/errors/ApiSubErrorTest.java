package com.zinworks.errors;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ApiSubErrorTest {

    @DisplayName("Test - ApiSubErrorTest - testConstructor")
    @Test
    public void testConstructor() {
        ApiSubError apiSubError = new ApiValidationError("object", "message");

        assertEquals("message", ((ApiValidationError) apiSubError).getMessage());
        assertEquals("object", ((ApiValidationError) apiSubError).getObject());
        assertNull(((ApiValidationError) apiSubError).getRejectedValue());
        assertNull(((ApiValidationError) apiSubError).getField());
    }
}
