package com.zinkworks;

import com.zinkworks.exceptions.AccountNotValidatedException;
import com.zinkworks.exceptions.DispenseNotAllowedExeption;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.validation.BindingResult;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.handler.DispatcherServletWebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class RestExceptionHandlerTest {

    private static final RestExceptionHandler restExceptionHandler = new RestExceptionHandler();
    private static final MethodParameter mockMethodParameter = Mockito.mock(MethodParameter.class);
    private static final BindingResult mockBindingResult = Mockito.mock(BindingResult.class);
    private static final WebRequest mockWebRequest = mock(ServletWebRequest.class);

    @DisplayName("Test - RestExceptionHandlerTest - testMissingServletRequestParameterException")
    @Test
    public void testMissingServletRequestParameterException() {
        MissingServletRequestParameterException missingServletRequestParameterException = new MissingServletRequestParameterException("parameterName", "parameterType");

        ResponseEntity<Object> result = restExceptionHandler.handleMissingServletRequestParameter(missingServletRequestParameterException, HttpHeaders.EMPTY, HttpStatus.BAD_REQUEST, mockWebRequest);

        HttpStatus expectedHttpStatus = HttpStatus.BAD_REQUEST;
        int expectedStatusCodeValue = 400;
        String bodyStart = "ApiError(status=400 BAD_REQUEST";
        String bodyEnd = "type parameterType is not present, subErrors=null)";
        assertResult(result, expectedHttpStatus, expectedStatusCodeValue, bodyStart, bodyEnd);
        verifyNoInteractions(mockMethodParameter, mockBindingResult,mockWebRequest);
    }

    @DisplayName("Test - RestExceptionHandlerTest - testHttpMediaTypeNotSupportedException")
    @Test
    public void testHttpMediaTypeNotSupportedException() {
        HttpMediaTypeNotSupportedException missingServletRequestParameterException = new HttpMediaTypeNotSupportedException("message");

        ResponseEntity<Object> result = restExceptionHandler.handleHttpMediaTypeNotSupported(missingServletRequestParameterException, HttpHeaders.EMPTY, HttpStatus.BAD_REQUEST, mockWebRequest);

        HttpStatus expectedHttpStatus = HttpStatus.UNSUPPORTED_MEDIA_TYPE;
        int expectedStatusCodeValue = 415;
        String bodyStart = "ApiError(status=415 UNSUPPORTED_MEDIA_TYPE, ";
        String bodyEnd = "message=null media type is not supported. Supported media types ar";
        assertResult(result, expectedHttpStatus, expectedStatusCodeValue, bodyStart, bodyEnd);
        verify(mockBindingResult).getFieldErrors();
        verify(mockBindingResult).getGlobalErrors();
    }

    @DisplayName("Test - RestExceptionHandlerTest - testMethodArgumentNotValidException")
    @Test
    public void testMethodArgumentNotValidException() {
        MethodArgumentNotValidException methodArgumentNotValidException = new MethodArgumentNotValidException(mockMethodParameter, mockBindingResult);

        ResponseEntity<Object> result = restExceptionHandler.handleMethodArgumentNotValid(methodArgumentNotValidException, HttpHeaders.EMPTY, HttpStatus.BAD_REQUEST, mockWebRequest);

        HttpStatus expectedHttpStatus = HttpStatus.BAD_REQUEST;
        int expectedStatusCodeValue = 400;
        String bodyStart = "ApiError(status=400 BAD_REQUEST";
        String bodyEnd = "message=Validation error";
        assertResult(result, expectedHttpStatus, expectedStatusCodeValue, bodyStart, bodyEnd);
        verify(mockBindingResult).getFieldErrors();
        verify(mockBindingResult).getGlobalErrors();
    }

    @DisplayName("Test - RestExceptionHandlerTest - testHandleDispenseNotAllowedExeption")
    @Test
    public void testHandleDispenseNotAllowedExeption() {
        DispenseNotAllowedExeption dispenseNotAllowedExeption = new DispenseNotAllowedExeption("message", 1l);

        ResponseEntity<Object> result = restExceptionHandler.handleDispenseNotAllowedExeption (dispenseNotAllowedExeption);

        HttpStatus expectedHttpStatus = HttpStatus.BAD_REQUEST;
        int expectedStatusCodeValue = 400;
        String bodyStart = "ApiError(status=400 BAD_REQUEST";
        String bodyEnd = "message=message, debugMessage=null, subErrors=null)";
        assertResult(result, expectedHttpStatus, expectedStatusCodeValue, bodyStart, bodyEnd);
        verifyNoInteractions(mockMethodParameter, mockBindingResult,mockWebRequest);
    }

    @DisplayName("Test - RestExceptionHandlerTest - testHandleDispenseNotAllowedExeption")
    @Test
    public void testRestExceptionHandler() {
        DispenseNotAllowedExeption dispenseNotAllowedExeption = new DispenseNotAllowedExeption("message", 1l);

        ResponseEntity<Object> result = restExceptionHandler.handleDispenseNotAllowedExeption (dispenseNotAllowedExeption);

        HttpStatus expectedHttpStatus = HttpStatus.BAD_REQUEST;
        int expectedStatusCodeValue = 400;
        String bodyStart = "ApiError(status=400 BAD_REQUEST";
        String bodyEnd = "message=message, debugMessage=null, subErrors=null)";
        assertResult(result, expectedHttpStatus, expectedStatusCodeValue, bodyStart, bodyEnd);
        verifyNoInteractions(mockMethodParameter, mockBindingResult,mockWebRequest);
    }

    @DisplayName("Test - RestExceptionHandlerTest - testHandleAccountNotValidatedException")
    @Test
    public void testHandleAccountNotValidatedException() {
        AccountNotValidatedException AccountNotValidatedException = new AccountNotValidatedException("message", 1l);

        ResponseEntity<Object> result = restExceptionHandler.handleAccountNotValidatedException(AccountNotValidatedException);

        HttpStatus expectedHttpStatus = HttpStatus.BAD_REQUEST;
        int expectedStatusCodeValue = 400;
        String bodyStart = "ApiError(status=400 BAD_REQUEST";
        String bodyEnd = "message=message, debugMessage=null, subErrors=null)";
        assertResult(result, expectedHttpStatus, expectedStatusCodeValue, bodyStart, bodyEnd);
        verifyNoInteractions(mockMethodParameter);
    }

    @DisplayName("Test - RestExceptionHandlerTest - testHttpMessageNotReadableException")
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

    @DisplayName("Test - RestExceptionHandlerTest - testHttpMessageNotWritableException")
    @Test
    public void testHttpMessageNotWritableException() {
        HttpMessageNotWritableException httpMessageNotWritableException = new HttpMessageNotWritableException("message");

        ResponseEntity<Object> result = restExceptionHandler.handleHttpMessageNotWritable(httpMessageNotWritableException, HttpHeaders.EMPTY, HttpStatus.BAD_REQUEST, mockWebRequest);

        HttpStatus expectedHttpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        int expectedStatusCodeValue = 500;
        String bodyStart = "ApiError(status=500 INTERNAL_SERVER_ERROR";
        String bodyEnd = "message=Error writing JSON output";
        assertResult(result, expectedHttpStatus, expectedStatusCodeValue, bodyStart, bodyEnd);
        verify(mockBindingResult).getFieldErrors();
        verify(mockBindingResult).getGlobalErrors();
    }

    @DisplayName("Test - RestExceptionHandlerTest - testHandleHttpMessageNotReadable")
    @Test
    public void testHandleHttpMessageNotReadable() {
        HttpMessageNotReadableException httpMessageNotReadableException = new HttpMessageNotReadableException("message");
        HttpServletRequest mockHttpServletRequest = Mockito.mock(HttpServletRequest.class);
        HttpServletResponse mockHttpServletResponse = Mockito.mock(HttpServletResponse.class);
        ServletWebRequest mockServletWebRequest = new DispatcherServletWebRequest(mockHttpServletRequest, mockHttpServletResponse);

        ResponseEntity<Object> result = restExceptionHandler.handleHttpMessageNotReadable(httpMessageNotReadableException, HttpHeaders.EMPTY, HttpStatus.BAD_REQUEST, mockServletWebRequest);

        HttpStatus expectedHttpStatus = HttpStatus.BAD_REQUEST;
        int expectedStatusCodeValue = 400;
        String bodyStart = "ApiError(status=400 BAD_REQUEST";
        String bodyEnd = "message=Malformed JSON request";
        assertResult(result, expectedHttpStatus, expectedStatusCodeValue, bodyStart, bodyEnd);
        verify(mockHttpServletRequest).getMethod();
    }

    @Test
    public void testHandleMethodArgumentTypeMismatch() {
        MethodArgumentTypeMismatchException mockMethodTypeMismatchException = Mockito.mock(MethodArgumentTypeMismatchException.class);

        ResponseEntity<Object> result = restExceptionHandler.handleMethodArgumentTypeMismatch(mockMethodTypeMismatchException, mockWebRequest);

        HttpStatus expectedHttpStatus = HttpStatus.BAD_REQUEST;
        int expectedStatusCodeValue = 400;
        String bodyStart = "ApiError(status=400 BAD_REQUEST";
        String bodyEnd = "could not be converted to type";
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
