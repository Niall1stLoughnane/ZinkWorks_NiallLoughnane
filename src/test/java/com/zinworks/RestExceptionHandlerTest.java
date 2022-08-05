package com.zinworks;

import com.zinworks.exceptions.AccountNotExistExeption;
import com.zinworks.exceptions.AccountNotValidatedExeption;
import com.zinworks.exceptions.AtmZeroCashExeption;
import com.zinworks.exceptions.DispenseNotAllowedExeption;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

public class RestExceptionHandlerTest {

    private static final RestExceptionHandler restExceptionHandler = new RestExceptionHandler();
    private static final MethodParameter mockMethodParameter = Mockito.mock(MethodParameter.class);
    private static final BindingResult mockBindingResult = Mockito.mock(BindingResult.class);
    private static final WebRequest mockWebRequest = mock(ServletWebRequest.class);

    @Test
    public void testMissingServletRequestParameterException() {
        MissingServletRequestParameterException missingServletRequestParameterException = new MissingServletRequestParameterException("parameterName", "parameterType");

        ResponseEntity<Object> result = restExceptionHandler.handleMissingServletRequestParameter(missingServletRequestParameterException, HttpHeaders.EMPTY, HttpStatus.BAD_REQUEST, mockWebRequest);

        HttpStatus expectedHttpStatus = HttpStatus.BAD_REQUEST;
        int expectedStatusCodeValue = 400;
        String bodyStart = "ApiError(status=400 BAD_REQUEST";
        String bodyEnd = "type parameterType is not present, subErrors=null)";
        assertResult(result, expectedHttpStatus, expectedStatusCodeValue, bodyStart, bodyEnd);
    }

    @Test
    public void testHttpMediaTypeNotSupportedException() {
        HttpMediaTypeNotSupportedException missingServletRequestParameterException = new HttpMediaTypeNotSupportedException("message");

        ResponseEntity<Object> result = restExceptionHandler.handleHttpMediaTypeNotSupported(missingServletRequestParameterException, HttpHeaders.EMPTY, HttpStatus.BAD_REQUEST, mockWebRequest);

        HttpStatus expectedHttpStatus = HttpStatus.UNSUPPORTED_MEDIA_TYPE;
        int expectedStatusCodeValue = 415;
        String bodyStart = "ApiError(status=415 UNSUPPORTED_MEDIA_TYPE, ";
        String bodyEnd = "message=null media type is not supported. Supported media types ar";
        assertResult(result, expectedHttpStatus, expectedStatusCodeValue, bodyStart, bodyEnd);
    }

    @Test
    public void testMethodArgumentNotValidException() {
        MethodArgumentNotValidException methodArgumentNotValidException = new MethodArgumentNotValidException(mockMethodParameter, mockBindingResult);

        ResponseEntity<Object> result = restExceptionHandler.handleMethodArgumentNotValid(methodArgumentNotValidException, HttpHeaders.EMPTY, HttpStatus.BAD_REQUEST, mockWebRequest);

        HttpStatus expectedHttpStatus = HttpStatus.BAD_REQUEST;
        int expectedStatusCodeValue = 400;
        String bodyStart = "ApiError(status=400 BAD_REQUEST";
        String bodyEnd = "message=Validation error";
        assertResult(result, expectedHttpStatus, expectedStatusCodeValue, bodyStart, bodyEnd);
    }

    @Test
    public void testHandleAtmZeroCashExeption() {
        AtmZeroCashExeption atmZeroCashExeption = new AtmZeroCashExeption("message", 1l);

        ResponseEntity<Object> result = restExceptionHandler.handleAtmZeroCashExeption(atmZeroCashExeption);

        HttpStatus expectedHttpStatus = HttpStatus.BAD_REQUEST;
        int expectedStatusCodeValue = 400;
        String bodyStart = "ApiError(status=400 BAD_REQUEST";
        String bodyEnd = "message=message, debugMessage=null, subErrors=null)";
        assertResult(result, expectedHttpStatus, expectedStatusCodeValue, bodyStart, bodyEnd);
    }

    @Test
    public void testHandleDispenseNotAllowedExeption() {
        DispenseNotAllowedExeption dispenseNotAllowedExeption = new DispenseNotAllowedExeption("message", 1l);

        ResponseEntity<Object> result = restExceptionHandler.handleDispenseNotAllowedExeption (dispenseNotAllowedExeption);

        HttpStatus expectedHttpStatus = HttpStatus.BAD_REQUEST;
        int expectedStatusCodeValue = 400;
        String bodyStart = "ApiError(status=400 BAD_REQUEST";
        String bodyEnd = "message=message, debugMessage=null, subErrors=null)";
        assertResult(result, expectedHttpStatus, expectedStatusCodeValue, bodyStart, bodyEnd);
    }

    @Test
    public void testHandleAccountNotValidatedExeption() {
        AccountNotValidatedExeption accountNotValidatedExeption = new AccountNotValidatedExeption("message", 1l);

        ResponseEntity<Object> result = restExceptionHandler.handleAccountNotValidatedExeption(accountNotValidatedExeption);

        HttpStatus expectedHttpStatus = HttpStatus.BAD_REQUEST;
        int expectedStatusCodeValue = 400;
        String bodyStart = "ApiError(status=400 BAD_REQUEST";
        String bodyEnd = "message=message, debugMessage=null, subErrors=null)";
        assertResult(result, expectedHttpStatus, expectedStatusCodeValue, bodyStart, bodyEnd);
    }

    @Test
    public void testHandleAccountNotExistExeption() {
        AccountNotExistExeption accountNotExistExeption = new AccountNotExistExeption("message", 1l);

        ResponseEntity<Object> result = restExceptionHandler.handleAccountNotExistExeption(accountNotExistExeption);

        HttpStatus expectedHttpStatus = HttpStatus.BAD_REQUEST;
        int expectedStatusCodeValue = 400;
        String bodyStart = "ApiError(status=400 BAD_REQUEST";
        String bodyEnd = "message=message, debugMessage=null, subErrors=null)";
        assertResult(result, expectedHttpStatus, expectedStatusCodeValue, bodyStart, bodyEnd);
    }

    @Test
    public void testHttpMessageNotReadableException() {
        MethodArgumentNotValidException methodArgumentNotValidException = new MethodArgumentNotValidException(mockMethodParameter, mockBindingResult);

        ResponseEntity<Object> result = restExceptionHandler.handleMethodArgumentNotValid(methodArgumentNotValidException, HttpHeaders.EMPTY, HttpStatus.BAD_REQUEST, mockWebRequest);

        HttpStatus expectedHttpStatus = HttpStatus.BAD_REQUEST;
        int expectedStatusCodeValue = 400;
        String bodyStart = "ApiError(status=400 BAD_REQUEST";
        String bodyEnd = "message=Validation error";
        assertResult(result, expectedHttpStatus, expectedStatusCodeValue, bodyStart, bodyEnd);
    }

    private void assertResult(ResponseEntity<Object> result, HttpStatus expectedHttpStatus, int expectedStatusCodeValue, String bodyStart, String bodyEnd) {
        assertEquals(expectedHttpStatus, result.getStatusCode());
        assertEquals(expectedStatusCodeValue, result.getStatusCodeValue());
        String bodyString = result.getBody().toString();
        assertTrue(bodyString.contains(bodyStart));
        assertTrue(bodyString.contains(bodyEnd));
        assertEquals(0, result.getHeaders().size());
    }
}
