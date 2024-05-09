package com.cts.employee.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.cts.employee.exception.NoRecordsException;
import com.cts.employee.model.Employee;
import com.cts.employee.repository.EmployeeDao;

import java.util.ArrayList;

import java.util.HashSet;
import java.util.List;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {EmployeeService.class})
@ExtendWith(SpringExtension.class)
class EmployeeServiceTest {
    @MockBean
    private EmployeeDao employeeDao;

    @Autowired
    private EmployeeService employeeService;

    /**
     * Method under test: {@link EmployeeService#employeeDetails()}
     */
    @Test
    void testEmployeeDetails() throws NoRecordsException {
        when(employeeDao.findAll()).thenReturn(new ArrayList<>());
        assertThrows(NoRecordsException.class, () -> employeeService.employeeDetails());
        verify(employeeDao).findAll();
    }

    /**
     * Method under test: {@link EmployeeService#employeeDetails()}
     */
    @Test
    void testEmployeeDetails2() throws NoRecordsException {
        Employee employee = new Employee();
        employee.setEmail("jane.doe@example.org");
        employee.setEngagedInJobs(new HashSet<>());
        employee.setFirstName("Jane");
        employee.setId(123L);
        employee.setLastName("Doe");
        employee.setSalary(1L);

        ArrayList<Employee> employeeList = new ArrayList<>();
        employeeList.add(employee);
        when(employeeDao.findAll()).thenReturn(employeeList);
        List<Employee> actualEmployeeDetailsResult = employeeService.employeeDetails();
        assertSame(employeeList, actualEmployeeDetailsResult);
        assertEquals(1, actualEmployeeDetailsResult.size());
        verify(employeeDao).findAll();
    }

    /**
     * Method under test: {@link EmployeeService#employeeDetails()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testEmployeeDetails3() throws NoRecordsException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: No Employee Records found
        //       at com.cts.employee.service.EmployeeService.employeeDetails(EmployeeService.java:19)
        //   In order to prevent employeeDetails()
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   employeeDetails().
        //   See https://diff.blue/R013 to resolve this issue.

        when(employeeDao.findAll()).thenThrow(new NullPointerException("No Employee Records found"));
        employeeService.employeeDetails();
    }

    /**
     * Method under test: {@link EmployeeService#employeeDetail(long)}
     */
    @Test
    void testEmployeeDetail() throws NoRecordsException {
        Employee employee = new Employee();
        employee.setEmail("jane.doe@example.org");
        employee.setEngagedInJobs(new HashSet<>());
        employee.setFirstName("Jane");
        employee.setId(123L);
        employee.setLastName("Doe");
        employee.setSalary(1L);
        when(employeeDao.existsById((Long) any())).thenReturn(true);
        when(employeeDao.getReferenceById((Long) any())).thenReturn(employee);
        assertSame(employee, employeeService.employeeDetail(123L));
        verify(employeeDao).existsById((Long) any());
        verify(employeeDao).getReferenceById((Long) any());
    }

    /**
     * Method under test: {@link EmployeeService#employeeDetail(long)}
     */
    @Test
    void testEmployeeDetail2() throws NoRecordsException {
        Employee employee = new Employee();
        employee.setEmail("jane.doe@example.org");
        employee.setEngagedInJobs(new HashSet<>());
        employee.setFirstName("Jane");
        employee.setId(123L);
        employee.setLastName("Doe");
        employee.setSalary(1L);
        when(employeeDao.existsById((Long) any())).thenReturn(false);
        when(employeeDao.getReferenceById((Long) any())).thenReturn(employee);
        assertThrows(NoRecordsException.class, () -> employeeService.employeeDetail(123L));
        verify(employeeDao).existsById((Long) any());
        verify(employeeDao).getReferenceById((Long) any());
    }

    /**
     * Method under test: {@link EmployeeService#employeeDetail(long)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testEmployeeDetail3() throws NoRecordsException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: foo
        //       at com.cts.employee.service.EmployeeService.employeeDetail(EmployeeService.java:27)
        //   In order to prevent employeeDetail(long)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   employeeDetail(long).
        //   See https://diff.blue/R013 to resolve this issue.

        when(employeeDao.existsById((Long) any())).thenThrow(new NullPointerException("foo"));
        when(employeeDao.getReferenceById((Long) any())).thenThrow(new NullPointerException("foo"));
        employeeService.employeeDetail(123L);
    }

    /**
     * Method under test: {@link EmployeeService#registerEmployee(Employee)}
     */
    @Test
    void testRegisterEmployee() {
        Employee employee = new Employee();
        employee.setEmail("jane.doe@example.org");
        employee.setEngagedInJobs(new HashSet<>());
        employee.setFirstName("Jane");
        employee.setId(123L);
        employee.setLastName("Doe");
        employee.setSalary(1L);
        when(employeeDao.save((Employee) any())).thenReturn(employee);

        Employee employee1 = new Employee();
        employee1.setEmail("jane.doe@example.org");
        employee1.setEngagedInJobs(new HashSet<>());
        employee1.setFirstName("Jane");
        employee1.setId(123L);
        employee1.setLastName("Doe");
        employee1.setSalary(1L);
        assertTrue(employeeService.registerEmployee(employee1));
        verify(employeeDao).save((Employee) any());
    }

    /**
     * Method under test: {@link EmployeeService#registerEmployee(Employee)}
     */
    @Test
    void testRegisterEmployee2() {
        when(employeeDao.save((Employee) any())).thenThrow(new NullPointerException("foo"));

        Employee employee = new Employee();
        employee.setEmail("jane.doe@example.org");
        employee.setEngagedInJobs(new HashSet<>());
        employee.setFirstName("Jane");
        employee.setId(123L);
        employee.setLastName("Doe");
        employee.setSalary(1L);
        assertThrows(Exception.class, () -> employeeService.registerEmployee(employee));
        verify(employeeDao).save((Employee) any());
    }

    /**
     * Method under test: {@link EmployeeService#deleteEmployee(long)}
     */
    @Test
    void testDeleteEmployee() {
        doNothing().when(employeeDao).deleteById((Long) any());
        assertTrue(employeeService.deleteEmployee(123L));
        verify(employeeDao).deleteById((Long) any());
    }

    /**
     * Method under test: {@link EmployeeService#deleteEmployee(long)}
     */
    @Test
    void testDeleteEmployee2() {
        doThrow(new NullPointerException("foo")).when(employeeDao).deleteById((Long) any());
        assertThrows(Exception.class, () -> employeeService.deleteEmployee(123L));
        verify(employeeDao).deleteById((Long) any());
    }
}

