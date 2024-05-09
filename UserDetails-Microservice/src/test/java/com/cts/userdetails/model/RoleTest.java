package com.cts.userdetails.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class RoleTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Role#Role()}
     *   <li>{@link Role#setName(String)}
     *   <li>{@link Role#setRoleId(long)}
     *   <li>{@link Role#getName()}
     *   <li>{@link Role#getRoleId()}
     * </ul>
     */
    @Test
    void testConstructor() {
        Role actualRole = new Role();
        actualRole.setName("Name");
        actualRole.setRoleId(123L);
        assertEquals("Name", actualRole.getName());
        assertEquals(123L, actualRole.getRoleId());
    }

    /**
     * Method under test: {@link Role#Role(long, String)}
     */
    @Test
    void testConstructor2() {
        Role actualRole = new Role(123L, "Name");

        assertEquals("Name", actualRole.getName());
        assertEquals(123L, actualRole.getRoleId());
    }
}

