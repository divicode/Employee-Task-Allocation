package com.cts.userdetails.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class LoginTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Login#Login()}
     *   <li>{@link Login#setPassword(String)}
     *   <li>{@link Login#setUserName(long)}
     *   <li>{@link Login#getPassword()}
     *   <li>{@link Login#getUserName()}
     * </ul>
     */
    @Test
    void testConstructor() {
        Login actualLogin = new Login();
        actualLogin.setPassword("iloveyou");
        actualLogin.setUserName(1L);
        assertEquals("iloveyou", actualLogin.getPassword());
        assertEquals(1L, actualLogin.getUserName());
    }

    /**
     * Method under test: {@link Login#Login(long, String)}
     */
    @Test
    void testConstructor2() {
        Login actualLogin = new Login(1L, "iloveyou");

        assertEquals("iloveyou", actualLogin.getPassword());
        assertEquals(1L, actualLogin.getUserName());
    }
}

