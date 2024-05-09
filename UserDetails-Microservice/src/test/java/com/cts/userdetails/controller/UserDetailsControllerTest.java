package com.cts.userdetails.controller;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.cts.userdetails.model.Login;
import com.cts.userdetails.model.Role;
import com.cts.userdetails.model.SuccessResponse;
import com.cts.userdetails.model.User;
import com.cts.userdetails.service.UserDetailsService;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;

@ContextConfiguration(classes = {UserDetailsController.class})
@ExtendWith(SpringExtension.class)
class UserDetailsControllerTest {
    @Autowired
    private UserDetailsController userDetailsController;

    @MockBean
    private UserDetailsService userDetailsService;

    /**
     * Method under test: {@link UserDetailsController#registerUser(User)}
     */
    @Test
    void testRegisterUser() throws Exception {
        when(userDetailsService.registerUser((User) any())).thenReturn("Register User");

        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setId(123L);
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setRoles(new ArrayList<>());
        String content = (new ObjectMapper()).writeValueAsString(user);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/RegisterUser")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(userDetailsController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Register User"));
    }

    /**
     * Method under test: {@link UserDetailsController#updateUser(User)}
     */
    @Test
    void testUpdateUser() throws Exception {
        when(userDetailsService.updateUser((User) any())).thenReturn(new SuccessResponse());

        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setId(123L);
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setRoles(new ArrayList<>());
        String content = (new ObjectMapper()).writeValueAsString(user);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/UpdateUser")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(userDetailsController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"message\":null,\"timestamp\":null}"));
    }

    /**
     * Method under test: {@link UserDetailsController#deleteUser(long)}
     */
    @Test
    void testDeleteUser() throws Exception {
        when(userDetailsService.deleteUser(anyLong())).thenReturn(new SuccessResponse());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/deleteUser/{id}", 123L);
        MockMvcBuilders.standaloneSetup(userDetailsController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"message\":null,\"timestamp\":null}"));
    }

    /**
     * Method under test: {@link UserDetailsController#deleteUser(long)}
     */
    @Test
    void testDeleteUser2() throws Exception {
        when(userDetailsService.deleteUser(anyLong())).thenReturn(new SuccessResponse());
        MockHttpServletRequestBuilder deleteResult = MockMvcRequestBuilders.delete("/deleteUser/{id}", 123L);
        deleteResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(userDetailsController)
                .build()
                .perform(deleteResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"message\":null,\"timestamp\":null}"));
    }

    /**
     * Method under test: {@link UserDetailsController#loadUserByName(long)}
     */
    @Test
    void testLoadUserByName() throws Exception {
        when(userDetailsService.loadUserByName(anyLong())).thenReturn(new Login(1L, "iloveyou"));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/loadUserByName/{userName}", 1L);
        MockMvcBuilders.standaloneSetup(userDetailsController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"userName\":1,\"password\":\"iloveyou\"}"));
    }

    /**
     * Method under test: {@link UserDetailsController#handleValidationExceptions(MethodArgumentNotValidException)}
     */
    @Test
    void testHandleValidationExceptions() {
        assertTrue(
                userDetailsController
                        .handleValidationExceptions(
                                new MethodArgumentNotValidException(null, new BindException("Target", "Object Name")))
                        .isEmpty());
    }

    /**
     * Method under test: {@link UserDetailsController#handleValidationExceptions(MethodArgumentNotValidException)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testHandleValidationExceptions2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.cts.userdetails.controller.UserDetailsController.handleValidationExceptions(UserDetailsController.java:75)
        //   In order to prevent handleValidationExceptions(MethodArgumentNotValidException)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   handleValidationExceptions(MethodArgumentNotValidException).
        //   See https://diff.blue/R013 to resolve this issue.

        userDetailsController.handleValidationExceptions(null);
    }

    /**
     * Method under test: {@link UserDetailsController#handleValidationExceptions(MethodArgumentNotValidException)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testHandleValidationExceptions3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.cts.userdetails.controller.UserDetailsController.handleValidationExceptions(UserDetailsController.java:75)
        //   In order to prevent handleValidationExceptions(MethodArgumentNotValidException)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   handleValidationExceptions(MethodArgumentNotValidException).
        //   See https://diff.blue/R013 to resolve this issue.

        userDetailsController.handleValidationExceptions(mock(MethodArgumentNotValidException.class));
    }

    /**
     * Method under test: {@link UserDetailsController#handleValidationExceptions(MethodArgumentNotValidException)}
     */
    @Test
    void testHandleValidationExceptions4() {
        BeanPropertyBindingResult beanPropertyBindingResult = mock(BeanPropertyBindingResult.class);
        when(beanPropertyBindingResult.getAllErrors()).thenReturn(new ArrayList<>());
        assertTrue(userDetailsController
                .handleValidationExceptions(new MethodArgumentNotValidException(null, beanPropertyBindingResult))
                .isEmpty());
        verify(beanPropertyBindingResult).getAllErrors();
    }

    /**
     * Method under test: {@link UserDetailsController#userPassword(long)}
     */
    @Test
    void testUserPassword() throws Exception {
        when(userDetailsService.userPasswordById(anyLong())).thenReturn(new SuccessResponse());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/getPasswordById/{id}", 123L);
        MockMvcBuilders.standaloneSetup(userDetailsController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"message\":null,\"timestamp\":null}"));
    }

    /**
     * Method under test: {@link UserDetailsController#userPassword(long)}
     */
    @Test
    void testUserPassword2() throws Exception {
        when(userDetailsService.userPasswordById(anyLong())).thenReturn(new SuccessResponse());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/getPasswordById/{id}", 123L);
        getResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(userDetailsController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"message\":null,\"timestamp\":null}"));
    }

    /**
     * Method under test: {@link UserDetailsController#userRole(long)}
     */
    @Test
    void testUserRole() throws Exception {
        Role role = new Role();
        role.setName("Name");
        role.setRoleId(123L);
        when(userDetailsService.userRoleById(anyLong())).thenReturn(role);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/getRoleById/{id}", 123L);
        MockMvcBuilders.standaloneSetup(userDetailsController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"roleId\":123,\"name\":\"Name\"}"));
    }
}

