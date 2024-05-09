package com.cts.employee.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.HashSet;

import org.junit.jupiter.api.Test;

class JobDetailTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link JobDetail#JobDetail()}
     *   <li>{@link JobDetail#setEndDateTime(String)}
     *   <li>{@link JobDetail#setEngagedEmployee(Employee)}
     *   <li>{@link JobDetail#setJobId(int)}
     *   <li>{@link JobDetail#setProfitValue(int)}
     *   <li>{@link JobDetail#setStartDateTime(String)}
     *   <li>{@link JobDetail#setStatus(String)}
     *   <li>{@link JobDetail#getEndDateTime()}
     *   <li>{@link JobDetail#getEngagedEmployee()}
     *   <li>{@link JobDetail#getJobId()}
     *   <li>{@link JobDetail#getProfitValue()}
     *   <li>{@link JobDetail#getStartDateTime()}
     *   <li>{@link JobDetail#getStatus()}
     * </ul>
     */
    @Test
    void testConstructor() {
        JobDetail actualJobDetail = new JobDetail();
        actualJobDetail.setEndDateTime("2020-03-01");
        Employee employee = new Employee();
        employee.setEmail("jane.doe@example.org");
        employee.setEngagedInJobs(new HashSet<>());
        employee.setFirstName("Jane");
        employee.setId(123L);
        employee.setLastName("Doe");
        employee.setSalary(1L);
        actualJobDetail.setEngagedEmployee(employee);
        actualJobDetail.setJobId(123);
        actualJobDetail.setProfitValue(42);
        actualJobDetail.setStartDateTime("2020-03-01");
        actualJobDetail.setStatus("Status");
        assertEquals("2020-03-01", actualJobDetail.getEndDateTime());
        assertSame(employee, actualJobDetail.getEngagedEmployee());
        assertEquals(123, actualJobDetail.getJobId());
        assertEquals(42, actualJobDetail.getProfitValue());
        assertEquals("2020-03-01", actualJobDetail.getStartDateTime());
        assertEquals("Status", actualJobDetail.getStatus());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link JobDetail#JobDetail(int, String, String, int, String, Employee)}
     *   <li>{@link JobDetail#setEndDateTime(String)}
     *   <li>{@link JobDetail#setEngagedEmployee(Employee)}
     *   <li>{@link JobDetail#setJobId(int)}
     *   <li>{@link JobDetail#setProfitValue(int)}
     *   <li>{@link JobDetail#setStartDateTime(String)}
     *   <li>{@link JobDetail#setStatus(String)}
     *   <li>{@link JobDetail#getEndDateTime()}
     *   <li>{@link JobDetail#getEngagedEmployee()}
     *   <li>{@link JobDetail#getJobId()}
     *   <li>{@link JobDetail#getProfitValue()}
     *   <li>{@link JobDetail#getStartDateTime()}
     *   <li>{@link JobDetail#getStatus()}
     * </ul>
     */
    @Test
    void testConstructor2() {
        Employee employee = new Employee();
        employee.setEmail("jane.doe@example.org");
        employee.setEngagedInJobs(new HashSet<>());
        employee.setFirstName("Jane");
        employee.setId(123L);
        employee.setLastName("Doe");
        employee.setSalary(1L);
        JobDetail actualJobDetail = new JobDetail(123, "2020-03-01", "2020-03-01", 42, "Status", employee);
        actualJobDetail.setEndDateTime("2020-03-01");
        Employee employee1 = new Employee();
        employee1.setEmail("jane.doe@example.org");
        employee1.setEngagedInJobs(new HashSet<>());
        employee1.setFirstName("Jane");
        employee1.setId(123L);
        employee1.setLastName("Doe");
        employee1.setSalary(1L);
        actualJobDetail.setEngagedEmployee(employee1);
        actualJobDetail.setJobId(123);
        actualJobDetail.setProfitValue(42);
        actualJobDetail.setStartDateTime("2020-03-01");
        actualJobDetail.setStatus("Status");
        assertEquals("2020-03-01", actualJobDetail.getEndDateTime());
        assertSame(employee1, actualJobDetail.getEngagedEmployee());
        assertEquals(123, actualJobDetail.getJobId());
        assertEquals(42, actualJobDetail.getProfitValue());
        assertEquals("2020-03-01", actualJobDetail.getStartDateTime());
        assertEquals("Status", actualJobDetail.getStatus());
    }
}

