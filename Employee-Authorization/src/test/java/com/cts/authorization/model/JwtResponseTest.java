package com.cts.authorization.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class JwtResponseTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link JwtResponse#JwtResponse(String)}
     *   <li>{@link JwtResponse#getToken()}
     * </ul>
     */
    @Test
    void testConstructor() {
        assertEquals("ABC123", (new JwtResponse("ABC123")).getToken());
    }
}

