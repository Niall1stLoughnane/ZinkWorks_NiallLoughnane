package com.zinworks.errors;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ApiValidationErrorTest {

    @Test
    public void testConstructor() {
        ApiValidationError apiValidationError = new ApiValidationError("object", "message");

        assertEquals("message", (apiValidationError).getMessage());
        assertEquals("object", (apiValidationError).getObject());
        assertNull(((ApiValidationError) apiValidationError).getRejectedValue());
        assertNull(((ApiValidationError) apiValidationError).getField());
    }

}
