package com.cts.employee.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class NoRecordsExceptionTest {
    /**
     * Method under test: {@link NoRecordsException#NoRecordsException(String)}
     */
    @Test
    void testConstructor() {
        NoRecordsException actualNoRecordsException = new NoRecordsException("An error occurred");
        assertNull(actualNoRecordsException.getCause());
        assertEquals(0, actualNoRecordsException.getSuppressed().length);
        assertEquals("An error occurred", actualNoRecordsException.getMessage());
        assertEquals("An error occurred", actualNoRecordsException.getLocalizedMessage());
    }
}

