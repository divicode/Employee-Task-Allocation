package com.cts.userdetails.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class UserTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link User#User()}
     *   <li>{@link User#setEmail(String)}
     *   <li>{@link User#setFirstName(String)}
     *   <li>{@link User#setId(long)}
     *   <li>{@link User#setLastName(String)}
     *   <li>{@link User#setPassword(String)}
     *   <li>{@link User#setRoles(List)}
     *   <li>{@link User#getEmail()}
     *   <li>{@link User#getFirstName()}
     *   <li>{@link User#getId()}
     *   <li>{@link User#getLastName()}
     *   <li>{@link User#getPassword()}
     *   <li>{@link User#getRoles()}
     * </ul>
     */
    @Test
    void testConstructor() {
        User actualUser = new User();
        actualUser.setEmail("jane.doe@example.org");
        actualUser.setFirstName("Jane");
        actualUser.setId(123L);
        actualUser.setLastName("Doe");
        actualUser.setPassword("iloveyou");
        ArrayList<Role> roleList = new ArrayList<>();
        actualUser.setRoles(roleList);
        assertEquals("jane.doe@example.org", actualUser.getEmail());
        assertEquals("Jane", actualUser.getFirstName());
        assertEquals(123L, actualUser.getId());
        assertEquals("Doe", actualUser.getLastName());
        assertEquals("iloveyou", actualUser.getPassword());
        assertSame(roleList, actualUser.getRoles());
    }

    /**
     * Method under test: {@link User#User(long, String, String, String, String, List)}
     */
    @Test
    void testConstructor2() {
        User actualUser = new User(123L, "Jane", "Doe", "jane.doe@example.org", "iloveyou", new ArrayList<>());

        assertEquals("jane.doe@example.org", actualUser.getEmail());
        assertTrue(actualUser.getRoles().isEmpty());
        assertEquals("iloveyou", actualUser.getPassword());
        assertEquals("Doe", actualUser.getLastName());
        assertEquals(123L, actualUser.getId());
        assertEquals("Jane", actualUser.getFirstName());
    }
}

