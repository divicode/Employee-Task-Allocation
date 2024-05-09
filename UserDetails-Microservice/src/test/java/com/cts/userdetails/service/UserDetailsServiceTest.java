package com.cts.userdetails.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.cts.userdetails.feign.EmployeeClient;
import com.cts.userdetails.model.Employee;
import com.cts.userdetails.model.Login;
import com.cts.userdetails.model.Role;
import com.cts.userdetails.model.SuccessResponse;
import com.cts.userdetails.model.User;
import com.cts.userdetails.repository.RoleDao;
import com.cts.userdetails.repository.UserDetailsDao;

import java.util.ArrayList;

import java.util.Date;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {UserDetailsService.class})
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class UserDetailsServiceTest {
    @MockBean
    private EmployeeClient employeeClient;

    @MockBean
    private RoleDao roleDao;

    @MockBean
    private SuccessResponse successResponse;

    @MockBean
    private UserDetailsDao userDetailsDao;

    @Autowired
    private UserDetailsService userDetailsService;

    /**
     * Method under test: {@link UserDetailsService#registerUser(User)}
     */
    @Test
    void testRegisterUser() {
        when(employeeClient.registerEmployee((Employee) any())).thenReturn(true);

        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setId(123L);
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setRoles(new ArrayList<>());
        when(userDetailsDao.save((User) any())).thenReturn(user);

        User user1 = new User();
        user1.setEmail("jane.doe@example.org");
        user1.setFirstName("Jane");
        user1.setId(123L);
        user1.setLastName("Doe");
        user1.setPassword("iloveyou");
        user1.setRoles(new ArrayList<>());
        assertEquals("User is registered successfully.", userDetailsService.registerUser(user1));
        verify(employeeClient).registerEmployee((Employee) any());
        verify(userDetailsDao).save((User) any());
    }

    /**
     * Method under test: {@link UserDetailsService#registerUser(User)}
     */
    @Test
    void testRegisterUser2() {
        when(employeeClient.registerEmployee((Employee) any())).thenReturn(true);
        when(userDetailsDao.save((User) any())).thenThrow(new NullPointerException("User is registered successfully."));

        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setId(123L);
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setRoles(new ArrayList<>());
        assertEquals("User is not registered...Try again..", userDetailsService.registerUser(user));
        verify(userDetailsDao).save((User) any());
    }

    /**
     * Method under test: {@link UserDetailsService#updateUser(User)}
     */
    @Test
    void testUpdateUser() {
        when(employeeClient.registerEmployee((Employee) any())).thenReturn(true);
        when(employeeClient.employeeDetail(anyLong()))
                .thenReturn(new Employee(123L, "Jane", "Doe", 1L, "jane.doe@example.org"));

        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setId(123L);
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setRoles(new ArrayList<>());
        Optional<User> ofResult = Optional.of(user);

        User user1 = new User();
        user1.setEmail("jane.doe@example.org");
        user1.setFirstName("Jane");
        user1.setId(123L);
        user1.setLastName("Doe");
        user1.setPassword("iloveyou");
        user1.setRoles(new ArrayList<>());
        when(userDetailsDao.save((User) any())).thenReturn(user1);
        when(userDetailsDao.findById((Long) any())).thenReturn(ofResult);
        doNothing().when(successResponse).setMessage((String) any());
        doNothing().when(successResponse).setTimestamp((Date) any());

        User user2 = new User();
        user2.setEmail("jane.doe@example.org");
        user2.setFirstName("Jane");
        user2.setId(123L);
        user2.setLastName("Doe");
        user2.setPassword("iloveyou");
        user2.setRoles(new ArrayList<>());
        userDetailsService.updateUser(user2);
        verify(employeeClient).registerEmployee((Employee) any());
        verify(employeeClient).employeeDetail(anyLong());
        verify(userDetailsDao).save((User) any());
        verify(userDetailsDao).findById((Long) any());
        verify(successResponse).setMessage((String) any());
        verify(successResponse).setTimestamp((Date) any());
    }

    /**
     * Method under test: {@link UserDetailsService#updateUser(User)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUpdateUser2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: User data is not Found
        //       at com.cts.userdetails.service.UserDetailsService.updateUser(UserDetailsService.java:70)
        //   In order to prevent updateUser(User)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   updateUser(User).
        //   See https://diff.blue/R013 to resolve this issue.

        when(employeeClient.registerEmployee((Employee) any())).thenReturn(true);
        when(employeeClient.employeeDetail(anyLong()))
                .thenReturn(new Employee(123L, "Jane", "Doe", 1L, "jane.doe@example.org"));

        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setId(123L);
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setRoles(new ArrayList<>());
        Optional<User> ofResult = Optional.of(user);

        User user1 = new User();
        user1.setEmail("jane.doe@example.org");
        user1.setFirstName("Jane");
        user1.setId(123L);
        user1.setLastName("Doe");
        user1.setPassword("iloveyou");
        user1.setRoles(new ArrayList<>());
        when(userDetailsDao.save((User) any())).thenReturn(user1);
        when(userDetailsDao.findById((Long) any())).thenReturn(ofResult);
        doThrow(new NullPointerException("User data is not Found")).when(successResponse).setMessage((String) any());
        doThrow(new NullPointerException("User data is not Found")).when(successResponse).setTimestamp((Date) any());

        User user2 = new User();
        user2.setEmail("jane.doe@example.org");
        user2.setFirstName("Jane");
        user2.setId(123L);
        user2.setLastName("Doe");
        user2.setPassword("iloveyou");
        user2.setRoles(new ArrayList<>());
        userDetailsService.updateUser(user2);
    }

    /**
     * Method under test: {@link UserDetailsService#updateUser(User)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUpdateUser3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.cts.userdetails.service.UserDetailsService.updateUser(UserDetailsService.java:64)
        //   In order to prevent updateUser(User)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   updateUser(User).
        //   See https://diff.blue/R013 to resolve this issue.

        when(employeeClient.registerEmployee((Employee) any())).thenReturn(true);
        when(employeeClient.employeeDetail(anyLong())).thenReturn(null);

        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setId(123L);
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setRoles(new ArrayList<>());
        Optional<User> ofResult = Optional.of(user);

        User user1 = new User();
        user1.setEmail("jane.doe@example.org");
        user1.setFirstName("Jane");
        user1.setId(123L);
        user1.setLastName("Doe");
        user1.setPassword("iloveyou");
        user1.setRoles(new ArrayList<>());
        when(userDetailsDao.save((User) any())).thenReturn(user1);
        when(userDetailsDao.findById((Long) any())).thenReturn(ofResult);
        doNothing().when(successResponse).setMessage((String) any());
        doNothing().when(successResponse).setTimestamp((Date) any());

        User user2 = new User();
        user2.setEmail("jane.doe@example.org");
        user2.setFirstName("Jane");
        user2.setId(123L);
        user2.setLastName("Doe");
        user2.setPassword("iloveyou");
        user2.setRoles(new ArrayList<>());
        userDetailsService.updateUser(user2);
    }

    /**
     * Method under test: {@link UserDetailsService#deleteUser(long)}
     */
    @Test
    void testDeleteUser() {
        when(employeeClient.deleteEmployee(anyLong())).thenReturn(true);
        doNothing().when(userDetailsDao).deleteById((Long) any());
        doNothing().when(successResponse).setMessage((String) any());
        doNothing().when(successResponse).setTimestamp((Date) any());
        userDetailsService.deleteUser(123L);
        verify(employeeClient).deleteEmployee(anyLong());
        verify(userDetailsDao).deleteById((Long) any());
        verify(successResponse).setMessage((String) any());
        verify(successResponse).setTimestamp((Date) any());
    }

    /**
     * Method under test: {@link UserDetailsService#deleteUser(long)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testDeleteUser2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: User is deleted successfully
        //       at com.cts.userdetails.service.UserDetailsService.deleteUser(UserDetailsService.java:80)
        //   In order to prevent deleteUser(long)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   deleteUser(long).
        //   See https://diff.blue/R013 to resolve this issue.

        when(employeeClient.deleteEmployee(anyLong())).thenReturn(true);
        doNothing().when(userDetailsDao).deleteById((Long) any());
        doThrow(new NullPointerException("User is deleted successfully")).when(successResponse)
                .setMessage((String) any());
        doThrow(new NullPointerException("User is deleted successfully")).when(successResponse)
                .setTimestamp((Date) any());
        userDetailsService.deleteUser(123L);
    }

    /**
     * Method under test: {@link UserDetailsService#deleteUser(long)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testDeleteUser3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: User is deleted successfully
        //       at com.cts.userdetails.service.UserDetailsService.deleteUser(UserDetailsService.java:79)
        //   In order to prevent deleteUser(long)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   deleteUser(long).
        //   See https://diff.blue/R013 to resolve this issue.

        when(employeeClient.deleteEmployee(anyLong())).thenReturn(true);
        doThrow(new NullPointerException("User is deleted successfully")).when(userDetailsDao).deleteById((Long) any());
        userDetailsService.deleteUser(123L);
    }

    /**
     * Method under test: {@link UserDetailsService#loadUserByName(long)}
     */
    @Test
    void testLoadUserByName() {
        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setId(123L);
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setRoles(new ArrayList<>());
        when(userDetailsDao.getReferenceById((Long) any())).thenReturn(user);
        Login actualLoadUserByNameResult = userDetailsService.loadUserByName(1L);
        assertEquals("iloveyou", actualLoadUserByNameResult.getPassword());
        assertEquals(123L, actualLoadUserByNameResult.getUserName());
        verify(userDetailsDao).getReferenceById((Long) any());
    }

    /**
     * Method under test: {@link UserDetailsService#loadUserByName(long)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testLoadUserByName2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: foo
        //       at com.cts.userdetails.service.UserDetailsService.loadUserByName(UserDetailsService.java:86)
        //   In order to prevent loadUserByName(long)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   loadUserByName(long).
        //   See https://diff.blue/R013 to resolve this issue.

        when(userDetailsDao.getReferenceById((Long) any())).thenThrow(new NullPointerException("foo"));
        userDetailsService.loadUserByName(1L);
    }

    /**
     * Method under test: {@link UserDetailsService#userDetail(long)}
     */
    @Test
    void testUserDetail() {
        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setId(123L);
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setRoles(new ArrayList<>());
        when(userDetailsDao.getReferenceById((Long) any())).thenReturn(user);
        assertSame(user, userDetailsService.userDetail(123L));
        verify(userDetailsDao).getReferenceById((Long) any());
    }

    /**
     * Method under test: {@link UserDetailsService#userDetail(long)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUserDetail2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: foo
        //       at com.cts.userdetails.service.UserDetailsService.userDetail(UserDetailsService.java:101)
        //   In order to prevent userDetail(long)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   userDetail(long).
        //   See https://diff.blue/R013 to resolve this issue.

        when(userDetailsDao.getReferenceById((Long) any())).thenThrow(new NullPointerException("foo"));
        userDetailsService.userDetail(123L);
    }

    /**
     * Method under test: {@link UserDetailsService#userRoleById(long)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUserRoleById() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.ArrayIndexOutOfBoundsException: 0
        //       at com.cts.userdetails.service.UserDetailsService.userRoleById(UserDetailsService.java:110)
        //   In order to prevent userRoleById(long)
        //   from throwing ArrayIndexOutOfBoundsException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   userRoleById(long).
        //   See https://diff.blue/R013 to resolve this issue.

        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setId(123L);
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setRoles(new ArrayList<>());
        when(userDetailsDao.getReferenceById((Long) any())).thenReturn(user);
        userDetailsService.userRoleById(123L);
    }

    /**
     * Method under test: {@link UserDetailsService#userRoleById(long)}
     */
    @Test
    void testUserRoleById2() {
        Role role = new Role();
        role.setName("Name");
        role.setRoleId(123L);

        ArrayList<Role> roleList = new ArrayList<>();
        roleList.add(role);

        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setId(123L);
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setRoles(roleList);
        when(userDetailsDao.getReferenceById((Long) any())).thenReturn(user);
        assertSame(role, userDetailsService.userRoleById(123L));
        verify(userDetailsDao).getReferenceById((Long) any());
    }

    /**
     * Method under test: {@link UserDetailsService#userRoleById(long)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUserRoleById3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: foo
        //       at com.cts.userdetails.service.UserDetailsService.userRoleById(UserDetailsService.java:106)
        //   In order to prevent userRoleById(long)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   userRoleById(long).
        //   See https://diff.blue/R013 to resolve this issue.

        when(userDetailsDao.getReferenceById((Long) any())).thenThrow(new NullPointerException("foo"));
        userDetailsService.userRoleById(123L);
    }

    /**
     * Method under test: {@link UserDetailsService#userPasswordById(long)}
     */
    @Test
    void testUserPasswordById() {
        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setId(123L);
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setRoles(new ArrayList<>());
        when(userDetailsDao.getReferenceById((Long) any())).thenReturn(user);
        doNothing().when(successResponse).setMessage((String) any());
        userDetailsService.userPasswordById(123L);
        verify(userDetailsDao).getReferenceById((Long) any());
        verify(successResponse).setMessage((String) any());
    }

    /**
     * Method under test: {@link UserDetailsService#userPasswordById(long)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUserPasswordById2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: foo
        //       at com.cts.userdetails.service.UserDetailsService.userPasswordById(UserDetailsService.java:115)
        //   In order to prevent userPasswordById(long)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   userPasswordById(long).
        //   See https://diff.blue/R013 to resolve this issue.

        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setId(123L);
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setRoles(new ArrayList<>());
        when(userDetailsDao.getReferenceById((Long) any())).thenReturn(user);
        doThrow(new NullPointerException("foo")).when(successResponse).setMessage((String) any());
        userDetailsService.userPasswordById(123L);
    }
}

