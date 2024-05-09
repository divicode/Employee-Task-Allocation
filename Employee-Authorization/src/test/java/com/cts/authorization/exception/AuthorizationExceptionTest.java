package com.cts.authorization.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class AuthorizationExceptionTest {
    /**
     * Method under test: {@link AuthorizationException#AuthorizationException(String)}
     */
    @Test
    void testConstructor() {
        AuthorizationException actualAuthorizationException = new AuthorizationException("An error occurred");
        assertNull(actualAuthorizationException.getCause());
        assertEquals(0, actualAuthorizationException.getSuppressed().length);
        assertEquals("An error occurred", actualAuthorizationException.getMessage());
        assertEquals("An error occurred", actualAuthorizationException.getLocalizedMessage());
    }
}

