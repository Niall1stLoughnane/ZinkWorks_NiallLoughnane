package com.zinkworks;

import com.zinkworks.ApiError;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ApiErrorTest {

    @DisplayName("Test - ApiErrorTest - testApiErrorWithHttpStatusBadRequest")
    @Test
    public void testApiErrorWithHttpStatusBadRequest() {
        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST);

        assertEquals(HttpStatus.BAD_REQUEST, apiError.getStatus());
        assertNotNull(apiError.getTimestamp());
        assertNull(apiError.getMessage());
        assertNull(apiError.getDebugMessage());
    }

    @DisplayName("Test - ApiErrorTest - testAddValidationErrors")
    @Test
    public void testAddValidationErrors() {
        FieldError fieldError = new FieldError("objectName", "field", "defaultMessage");
        List<FieldError> fieldErrors = Arrays.asList(fieldError, fieldError);

        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST);

        apiError.addValidationErrors(fieldErrors);

        assertEquals(HttpStatus.BAD_REQUEST, apiError.getStatus());
        assertNotNull(apiError.getTimestamp());
        assertNull(apiError.getMessage());
        assertNull(apiError.getDebugMessage());
        assertEquals(2, apiError.getSubErrors().size());
    }

    @DisplayName("Test - ApiErrorTest - testAddValidationError")
    @Test
    public void testAddValidationError() {
        ObjectError objectError = new ObjectError("objectName", "defaultMessage");
        List<ObjectError> objectErrors = Arrays.asList(objectError, objectError);

        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST);

        apiError.addValidationError(objectErrors);

        assertEquals(HttpStatus.BAD_REQUEST, apiError.getStatus());
        assertNotNull(apiError.getTimestamp());
        assertNull(apiError.getMessage());
        assertNull(apiError.getDebugMessage());
        assertEquals(2, apiError.getSubErrors().size());
    }
}
