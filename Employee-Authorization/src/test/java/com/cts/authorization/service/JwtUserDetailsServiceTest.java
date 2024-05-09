package com.cts.authorization.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.cts.authorization.feign.UserServiceFeignClient;
import com.cts.authorization.model.User;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {JwtUserDetailsService.class})
@ExtendWith(SpringExtension.class)
class JwtUserDetailsServiceTest {
    @Autowired
    private JwtUserDetailsService jwtUserDetailsService;

    @MockBean
    private PasswordEncoder passwordEncoder;

    @MockBean
    private UserServiceFeignClient userServiceFeignClient;

    /**
     * Method under test: {@link JwtUserDetailsService#loadUserByUsername(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testLoadUserByUsername() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "janedoe"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.parseLong(Long.java:631)
        //       at com.cts.authorization.service.JwtUserDetailsService.loadUserByUsername(JwtUserDetailsService.java:36)
        //   In order to prevent loadUserByUsername(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   loadUserByUsername(String).
        //   See https://diff.blue/R013 to resolve this issue.

        jwtUserDetailsService.loadUserByUsername("janedoe");
    }

    /**
     * Method under test: {@link JwtUserDetailsService#loadUserByUsername(String)}
     */
    @Test
    void testLoadUserByUsername2() {
        when(userServiceFeignClient.loadUserByName(anyLong())).thenReturn(new User("janedoe", "iloveyou"));
        assertEquals("iloveyou", jwtUserDetailsService.loadUserByUsername("42").getPassword());
        verify(userServiceFeignClient).loadUserByName(anyLong());
    }

    /**
     * Method under test: {@link JwtUserDetailsService#loadUserByUsername(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testLoadUserByUsername3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException: Cannot pass null or empty values to constructor
        //       at org.springframework.util.Assert.isTrue(Assert.java:121)
        //       at org.springframework.security.core.userdetails.User.<init>(User.java:110)
        //       at org.springframework.security.core.userdetails.User.<init>(User.java:87)
        //       at com.cts.authorization.service.JwtUserDetailsService.loadUserByUsername(JwtUserDetailsService.java:43)
        //   In order to prevent loadUserByUsername(String)
        //   from throwing IllegalArgumentException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   loadUserByUsername(String).
        //   See https://diff.blue/R013 to resolve this issue.

        when(userServiceFeignClient.loadUserByName(anyLong())).thenReturn(new User(null, "iloveyou"));
        jwtUserDetailsService.loadUserByUsername("42");
    }

    /**
     * Method under test: {@link JwtUserDetailsService#loadUserByUsername(String)}
     */
    @Test
    void testLoadUserByUsername4() {
        when(userServiceFeignClient.loadUserByName(anyLong())).thenReturn(null);
        assertThrows(UsernameNotFoundException.class, () -> jwtUserDetailsService.loadUserByUsername("42"));
        verify(userServiceFeignClient).loadUserByName(anyLong());
    }

    /**
     * Method under test: {@link JwtUserDetailsService#loadUserByUsername(String)}
     */
    @Test
    void testLoadUserByUsername5() {
        User user = mock(User.class);
        when(user.getPassword()).thenThrow(new UsernameNotFoundException("Msg"));
        when(user.getUserName()).thenThrow(new UsernameNotFoundException("Msg"));
        when(userServiceFeignClient.loadUserByName(anyLong())).thenReturn(user);
        assertThrows(UsernameNotFoundException.class, () -> jwtUserDetailsService.loadUserByUsername("42"));
        verify(userServiceFeignClient).loadUserByName(anyLong());
        verify(user).getUserName();
    }
}

