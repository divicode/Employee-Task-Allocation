package com.cts.employee.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

class EmployeeTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Employee#Employee()}
     *   <li>{@link Employee#setEmail(String)}
     *   <li>{@link Employee#setEngagedInJobs(Set)}
     *   <li>{@link Employee#setFirstName(String)}
     *   <li>{@link Employee#setId(long)}
     *   <li>{@link Employee#setLastName(String)}
     *   <li>{@link Employee#setSalary(long)}
     *   <li>{@link Employee#getEmail()}
     *   <li>{@link Employee#getEngagedInJobs()}
     *   <li>{@link Employee#getFirstName()}
     *   <li>{@link Employee#getId()}
     *   <li>{@link Employee#getLastName()}
     *   <li>{@link Employee#getSalary()}
     * </ul>
     */
    @Test
    void testConstructor() {
        Employee actualEmployee = new Employee();
        actualEmployee.setEmail("jane.doe@example.org");
        HashSet<JobDetail> jobDetailSet = new HashSet<>();
        actualEmployee.setEngagedInJobs(jobDetailSet);
        actualEmployee.setFirstName("Jane");
        actualEmployee.setId(123L);
        actualEmployee.setLastName("Doe");
        actualEmployee.setSalary(1L);
        assertEquals("jane.doe@example.org", actualEmployee.getEmail());
        assertSame(jobDetailSet, actualEmployee.getEngagedInJobs());
        assertEquals("Jane", actualEmployee.getFirstName());
        assertEquals(123L, actualEmployee.getId());
        assertEquals("Doe", actualEmployee.getLastName());
        assertEquals(1L, actualEmployee.getSalary());
    }

    /**
     * Method under test: {@link Employee#Employee(long, String, String, long, String, Set)}
     */
    @Test
    void testConstructor2() {
        Employee actualEmployee = new Employee(123L, "Jane", "Doe", 1L, "jane.doe@example.org", new HashSet<>());

        assertEquals("jane.doe@example.org", actualEmployee.getEmail());
        assertEquals(1L, actualEmployee.getSalary());
        assertEquals("Doe", actualEmployee.getLastName());
        assertEquals(123L, actualEmployee.getId());
        assertEquals("Jane", actualEmployee.getFirstName());
        assertTrue(actualEmployee.getEngagedInJobs().isEmpty());
    }
}

