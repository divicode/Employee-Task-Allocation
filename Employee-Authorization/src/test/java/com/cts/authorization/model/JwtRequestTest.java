package com.cts.authorization.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class JwtRequestTest {
    /**
     * Method under test: {@link JwtRequest#JwtRequest()}
     */
    @Test
    void testConstructor() {
        JwtRequest actualJwtRequest = new JwtRequest();
        assertNull(actualJwtRequest.getPassword());
        assertNull(actualJwtRequest.getUserName());
    }

    /**
     * Method under test: {@link JwtRequest#JwtRequest(String, String)}
     */
    @Test
    void testConstructor2() {
        JwtRequest actualJwtRequest = new JwtRequest("janedoe", "iloveyou");

        assertEquals("iloveyou", actualJwtRequest.getPassword());
        assertEquals("janedoe", actualJwtRequest.getUserName());
    }
}

