package com.zinworks.errors;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ApiValidationErrorTest {

    @DisplayName("Test - ApiValidationErrorTest - testConstructor")
    @Test
    public void testConstructor() {
        ApiValidationError apiValidationError = new ApiValidationError("object", "message");

        assertEquals("message", (apiValidationError).getMessage());
        assertEquals("object", (apiValidationError).getObject());
        assertNull(((ApiValidationError) apiValidationError).getRejectedValue());
        assertNull(((ApiValidationError) apiValidationError).getField());
    }

    @DisplayName("Test - ApiValidationErrorTest - testAllConstructor")
    @Test
    public void testAllConstructor() {
        Object rejectedValue = new Object();
        ApiValidationError apiValidationError = new ApiValidationError("object", "message", rejectedValue, "message");

        assertEquals("message", (apiValidationError).getMessage());
        assertEquals("object", (apiValidationError).getObject());
        assertEquals(rejectedValue,  apiValidationError.getRejectedValue());
        assertEquals("message", apiValidationError.getField());
    }

    @DisplayName("Test - ApiValidationErrorTest - testData_EqualsAndHashCode")
    @Test
    public void testData_EqualsAndHashCode(){
        ApiValidationError apiValidationError = new ApiValidationError("object", "message");

        assertEquals(apiValidationError, apiValidationError);
        assertEquals(apiValidationError.hashCode(), apiValidationError.hashCode());

        ApiValidationError apiValidationError2 = new ApiValidationError("object2", "message2");

        assertNotEquals(apiValidationError, apiValidationError2);
        assertNotEquals(apiValidationError.hashCode(), apiValidationError2.hashCode());
    }

    @DisplayName("Test - ApiValidationErrorTest - testData_GetterAndSetters")
    @Test
    public void testData_GetterAndSetters(){
        ApiValidationError apiValidationError = new ApiValidationError("object", "message");

        assertEquals("message", (apiValidationError).getMessage());
        assertEquals("object", (apiValidationError).getObject());
        assertNull((apiValidationError).getRejectedValue());
        assertNull((apiValidationError).getField());

        apiValidationError.setField("newField");
        apiValidationError.setMessage("newMessage");
        apiValidationError.setObject("newObject");
        apiValidationError.setRejectedValue("newRejectedValue");

        assertEquals("newMessage", (apiValidationError).getMessage());
        assertEquals("newObject", (apiValidationError).getObject());
        assertEquals("newRejectedValue", (apiValidationError).getRejectedValue());
        assertEquals("newField", (apiValidationError).getField());
    }

}
