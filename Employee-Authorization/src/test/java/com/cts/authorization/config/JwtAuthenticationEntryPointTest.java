package com.cts.authorization.config;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {JwtAuthenticationEntryPoint.class})
@ExtendWith(SpringExtension.class)
class JwtAuthenticationEntryPointTest {
    @Autowired
    private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

    /**
     * Method under test: {@link JwtAuthenticationEntryPoint#commence(HttpServletRequest, HttpServletResponse, AuthenticationException)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCommence() throws IOException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at org.apache.catalina.connector.Response.isCommitted(Response.java:619)
        //       at org.apache.catalina.connector.Response.sendError(Response.java:1277)
        //       at com.cts.authorization.config.JwtAuthenticationEntryPoint.commence(JwtAuthenticationEntryPoint.java:22)
        //   In order to prevent commence(HttpServletRequest, HttpServletResponse, AuthenticationException)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   commence(HttpServletRequest, HttpServletResponse, AuthenticationException).
        //   See https://diff.blue/R013 to resolve this issue.

        MockHttpServletRequest request = new MockHttpServletRequest();
        Response response = new Response();
        jwtAuthenticationEntryPoint.commence(request, response, new AccountExpiredException("Msg"));
    }

    /**
     * Method under test: {@link JwtAuthenticationEntryPoint#commence(HttpServletRequest, HttpServletResponse, AuthenticationException)}
     */
    @Test
    void testCommence2() throws IOException {
        // TODO: Complete this test.
        //   Reason: R004 No meaningful assertions found.
        //   Diffblue Cover was unable to create an assertion.
        //   Make sure that fields modified by commence(HttpServletRequest, HttpServletResponse, AuthenticationException)
        //   have package-private, protected, or public getters.
        //   See https://diff.blue/R004 to resolve this issue.

        MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();
        jwtAuthenticationEntryPoint.commence(request, response, new AccountExpiredException("Msg"));
    }

    /**
     * Method under test: {@link JwtAuthenticationEntryPoint#commence(HttpServletRequest, HttpServletResponse, AuthenticationException)}
     */
    @Test
    void testCommence3() throws IOException {
        MockHttpServletRequest request = new MockHttpServletRequest();
        Response response = mock(Response.class);
        doNothing().when(response).sendError(anyInt(), (String) any());
        jwtAuthenticationEntryPoint.commence(request, response, new AccountExpiredException("Msg"));
        verify(response).sendError(anyInt(), (String) any());
    }
}

