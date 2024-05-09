package com.cts.authorization.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

class ExceptionDetailsTest {
    /**
     * Method under test: {@link ExceptionDetails#ExceptionDetails(LocalDateTime, String)}
     */
    @Test
    void testConstructor() {
        LocalDateTime ofResult = LocalDateTime.of(1, 1, 1, 1, 1);
        ExceptionDetails actualExceptionDetails = new ExceptionDetails(ofResult, "An error occurred");

        assertEquals("An error occurred", actualExceptionDetails.getMessage());
        LocalDateTime timeStamp = actualExceptionDetails.getTimeStamp();
        assertSame(ofResult, timeStamp);
        assertEquals("0001-01-01", timeStamp.toLocalDate().toString());
        assertEquals("01:01", timeStamp.toLocalTime().toString());
    }
}

