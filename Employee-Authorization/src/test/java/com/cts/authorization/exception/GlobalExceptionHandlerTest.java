package com.cts.authorization.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

class GlobalExceptionHandlerTest {
    /**
     * Method under test: {@link GlobalExceptionHandler#handleHttpMessageNotReadable(HttpMessageNotReadableException, HttpHeaders, HttpStatus, WebRequest)}
     */
    @Test
    void testHandleHttpMessageNotReadable() {
        GlobalExceptionHandler globalExceptionHandler = new GlobalExceptionHandler();
        HttpMessageNotReadableException ex = new HttpMessageNotReadableException("https://example.org/example");
        HttpHeaders headers = new HttpHeaders();
        ResponseEntity<Object> actualHandleHttpMessageNotReadableResult = globalExceptionHandler
                .handleHttpMessageNotReadable(ex, headers, HttpStatus.CONTINUE,
                        new ServletWebRequest(new MockHttpServletRequest()));
        assertTrue(actualHandleHttpMessageNotReadableResult.hasBody());
        assertTrue(actualHandleHttpMessageNotReadableResult.getHeaders().isEmpty());
        assertEquals(HttpStatus.CONTINUE, actualHandleHttpMessageNotReadableResult.getStatusCode());
        assertEquals("https://example.org/example",
                ((ExceptionDetails) actualHandleHttpMessageNotReadableResult.getBody()).getMessage());
    }

    /**
     * Method under test: {@link GlobalExceptionHandler#handleHttpMessageNotReadable(HttpMessageNotReadableException, HttpHeaders, HttpStatus, WebRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testHandleHttpMessageNotReadable2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.cts.authorization.exception.GlobalExceptionHandler.handleHttpMessageNotReadable(GlobalExceptionHandler.java:22)
        //   In order to prevent handleHttpMessageNotReadable(HttpMessageNotReadableException, HttpHeaders, HttpStatus, WebRequest)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   handleHttpMessageNotReadable(HttpMessageNotReadableException, HttpHeaders, HttpStatus, WebRequest).
        //   See https://diff.blue/R013 to resolve this issue.

        GlobalExceptionHandler globalExceptionHandler = new GlobalExceptionHandler();
        HttpHeaders headers = new HttpHeaders();
        globalExceptionHandler.handleHttpMessageNotReadable(null, headers, HttpStatus.CONTINUE,
                new ServletWebRequest(new MockHttpServletRequest()));
    }

    /**
     * Method under test: {@link GlobalExceptionHandler#handleHttpMessageNotReadable(HttpMessageNotReadableException, HttpHeaders, HttpStatus, WebRequest)}
     */
    @Test
    void testHandleHttpMessageNotReadable3() {
        GlobalExceptionHandler globalExceptionHandler = new GlobalExceptionHandler();
        HttpMessageNotReadableException ex = new HttpMessageNotReadableException("https://example.org/example");
        HttpHeaders headers = new HttpHeaders();
        ResponseEntity<Object> actualHandleHttpMessageNotReadableResult = globalExceptionHandler
                .handleHttpMessageNotReadable(ex, headers, HttpStatus.SWITCHING_PROTOCOLS,
                        new ServletWebRequest(new MockHttpServletRequest()));
        assertTrue(actualHandleHttpMessageNotReadableResult.hasBody());
        assertTrue(actualHandleHttpMessageNotReadableResult.getHeaders().isEmpty());
        assertEquals(HttpStatus.SWITCHING_PROTOCOLS, actualHandleHttpMessageNotReadableResult.getStatusCode());
        assertEquals("https://example.org/example",
                ((ExceptionDetails) actualHandleHttpMessageNotReadableResult.getBody()).getMessage());
    }

    /**
     * Method under test: {@link GlobalExceptionHandler#handleHttpMessageNotReadable(HttpMessageNotReadableException, HttpHeaders, HttpStatus, WebRequest)}
     */
    @Test
    void testHandleHttpMessageNotReadable4() {
        GlobalExceptionHandler globalExceptionHandler = new GlobalExceptionHandler();
        HttpMessageNotReadableException ex = new HttpMessageNotReadableException("https://example.org/example");
        HttpHeaders headers = new HttpHeaders();
        ResponseEntity<Object> actualHandleHttpMessageNotReadableResult = globalExceptionHandler
                .handleHttpMessageNotReadable(ex, headers, HttpStatus.PROCESSING,
                        new ServletWebRequest(new MockHttpServletRequest()));
        assertTrue(actualHandleHttpMessageNotReadableResult.hasBody());
        assertTrue(actualHandleHttpMessageNotReadableResult.getHeaders().isEmpty());
        assertEquals(HttpStatus.PROCESSING, actualHandleHttpMessageNotReadableResult.getStatusCode());
        assertEquals("https://example.org/example",
                ((ExceptionDetails) actualHandleHttpMessageNotReadableResult.getBody()).getMessage());
    }

    /**
     * Method under test: {@link GlobalExceptionHandler#handleHttpMessageNotReadable(HttpMessageNotReadableException, HttpHeaders, HttpStatus, WebRequest)}
     */
    @Test
    void testHandleHttpMessageNotReadable5() {
        GlobalExceptionHandler globalExceptionHandler = new GlobalExceptionHandler();
        HttpMessageNotReadableException ex = new HttpMessageNotReadableException("https://example.org/example");
        HttpHeaders headers = new HttpHeaders();
        ResponseEntity<Object> actualHandleHttpMessageNotReadableResult = globalExceptionHandler
                .handleHttpMessageNotReadable(ex, headers, HttpStatus.CHECKPOINT,
                        new ServletWebRequest(new MockHttpServletRequest()));
        assertTrue(actualHandleHttpMessageNotReadableResult.hasBody());
        assertTrue(actualHandleHttpMessageNotReadableResult.getHeaders().isEmpty());
        assertEquals(HttpStatus.CHECKPOINT, actualHandleHttpMessageNotReadableResult.getStatusCode());
        assertEquals("https://example.org/example",
                ((ExceptionDetails) actualHandleHttpMessageNotReadableResult.getBody()).getMessage());
    }

    /**
     * Method under test: {@link GlobalExceptionHandler#handleHttpMessageNotReadable(HttpMessageNotReadableException, HttpHeaders, HttpStatus, WebRequest)}
     */
    @Test
    void testHandleHttpMessageNotReadable6() {
        GlobalExceptionHandler globalExceptionHandler = new GlobalExceptionHandler();
        HttpMessageNotReadableException ex = new HttpMessageNotReadableException("https://example.org/example");
        HttpHeaders headers = new HttpHeaders();
        ResponseEntity<Object> actualHandleHttpMessageNotReadableResult = globalExceptionHandler
                .handleHttpMessageNotReadable(ex, headers, HttpStatus.OK,
                        new ServletWebRequest(new MockHttpServletRequest()));
        assertTrue(actualHandleHttpMessageNotReadableResult.hasBody());
        assertTrue(actualHandleHttpMessageNotReadableResult.getHeaders().isEmpty());
        assertEquals(HttpStatus.OK, actualHandleHttpMessageNotReadableResult.getStatusCode());
        assertEquals("https://example.org/example",
                ((ExceptionDetails) actualHandleHttpMessageNotReadableResult.getBody()).getMessage());
    }

    /**
     * Method under test: {@link GlobalExceptionHandler#handleGlobalException(AuthorizationException, WebRequest)}
     */
    @Test
    void testHandleGlobalException() {
        GlobalExceptionHandler globalExceptionHandler = new GlobalExceptionHandler();
        AuthorizationException ex = new AuthorizationException("An error occurred");
        ResponseEntity<Object> actualHandleGlobalExceptionResult = globalExceptionHandler.handleGlobalException(ex,
                new ServletWebRequest(new MockHttpServletRequest()));
        assertTrue(actualHandleGlobalExceptionResult.hasBody());
        assertTrue(actualHandleGlobalExceptionResult.getHeaders().isEmpty());
        assertEquals(HttpStatus.UNAUTHORIZED, actualHandleGlobalExceptionResult.getStatusCode());
        assertEquals("An error occurred", ((ExceptionDetails) actualHandleGlobalExceptionResult.getBody()).getMessage());
    }

    /**
     * Method under test: {@link GlobalExceptionHandler#handleGlobalException(AuthorizationException, WebRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testHandleGlobalException2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.cts.authorization.exception.GlobalExceptionHandler.handleGlobalException(GlobalExceptionHandler.java:29)
        //   In order to prevent handleGlobalException(AuthorizationException, WebRequest)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   handleGlobalException(AuthorizationException, WebRequest).
        //   See https://diff.blue/R013 to resolve this issue.

        GlobalExceptionHandler globalExceptionHandler = new GlobalExceptionHandler();
        globalExceptionHandler.handleGlobalException((AuthorizationException) null,
                new ServletWebRequest(new MockHttpServletRequest()));
    }

    /**
     * Method under test: {@link GlobalExceptionHandler#handleGlobalException(Exception, WebRequest)}
     */
    @Test
    void testHandleGlobalException3() {
        GlobalExceptionHandler globalExceptionHandler = new GlobalExceptionHandler();
        Exception ex = new Exception("foo");
        ResponseEntity<Object> actualHandleGlobalExceptionResult = globalExceptionHandler.handleGlobalException(ex,
                new ServletWebRequest(new MockHttpServletRequest()));
        assertTrue(actualHandleGlobalExceptionResult.hasBody());
        assertTrue(actualHandleGlobalExceptionResult.getHeaders().isEmpty());
        assertEquals(HttpStatus.UNAUTHORIZED, actualHandleGlobalExceptionResult.getStatusCode());
        assertEquals("foo", ((ExceptionDetails) actualHandleGlobalExceptionResult.getBody()).getMessage());
    }

    /**
     * Method under test: {@link GlobalExceptionHandler#handleGlobalException(Exception, WebRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testHandleGlobalException4() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.cts.authorization.exception.GlobalExceptionHandler.handleGlobalException(GlobalExceptionHandler.java:36)
        //   In order to prevent handleGlobalException(Exception, WebRequest)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   handleGlobalException(Exception, WebRequest).
        //   See https://diff.blue/R013 to resolve this issue.

        GlobalExceptionHandler globalExceptionHandler = new GlobalExceptionHandler();
        globalExceptionHandler.handleGlobalException((Exception) null,
                new ServletWebRequest(new MockHttpServletRequest()));
    }
}

