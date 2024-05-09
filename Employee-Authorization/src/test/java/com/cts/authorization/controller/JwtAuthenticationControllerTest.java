package com.cts.authorization.controller;

import static org.junit.jupiter.api.Assertions.assertFalse;

import com.cts.authorization.config.JwtTokenUtil;
import com.cts.authorization.model.JwtRequest;
import com.cts.authorization.service.JwtUserDetailsService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {JwtAuthenticationController.class})
@ExtendWith(SpringExtension.class)
class JwtAuthenticationControllerTest {
    @MockBean
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtAuthenticationController jwtAuthenticationController;

    @MockBean
    private JwtTokenUtil jwtTokenUtil;

    @MockBean
    private JwtUserDetailsService jwtUserDetailsService;

    /**
     * Method under test: {@link JwtAuthenticationController#authorizeTheRequest(String)}
     */
    @Test
    void testAuthorizeTheRequest() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: F009 Internal error.
        //   java.lang.StackOverflowError
        //   Please contact Diffblue through the appropriate support channel
        //   (https://www.diffblue.com/support/) providing details about this error.

        assertFalse((new JwtAuthenticationController()).authorizeTheRequest("ABC123"));
        assertFalse((new JwtAuthenticationController()).authorizeTheRequest(null));
    }

    /**
     * Method under test: {@link JwtAuthenticationController#authorizeTheRequest(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testAuthorizeTheRequest2() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: F009 Internal error.
        //   java.lang.StackOverflowError
        //   Please contact Diffblue through the appropriate support channel
        //   (https://www.diffblue.com/support/) providing details about this error.

        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.cts.authorization.controller.JwtAuthenticationController.authorizeTheRequest(JwtAuthenticationController.java:84)
        //   In order to prevent authorizeTheRequest(String)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   authorizeTheRequest(String).
        //   See https://diff.blue/R013 to resolve this issue.

        (new JwtAuthenticationController()).authorizeTheRequest("Bearer ");
    }

    /**
     * Method under test: {@link JwtAuthenticationController#createAuthenticationToken(JwtRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreateAuthenticationToken() throws Exception {
        // TODO: Complete this test.
        //   Reason: F009 Internal error.
        //   java.lang.StackOverflowError
        //   Please contact Diffblue through the appropriate support channel
        //   (https://www.diffblue.com/support/) providing details about this error.

        // Arrange
        // TODO: Populate arranged inputs
        Object[] uriVars = new Object[]{};
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/authenticate", uriVars)
                .contentType(MediaType.APPLICATION_JSON);

        JwtRequest jwtRequest = new JwtRequest();
        jwtRequest.setPassword("iloveyou");
        jwtRequest.setUserName("janedoe");

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(jwtRequest));
        Object[] controllers = new Object[]{jwtAuthenticationController};
        MockMvc buildResult = MockMvcBuilders.standaloneSetup(controllers).build();

        // Act
        ResultActions actualPerformResult = buildResult.perform(requestBuilder);

        // Assert
        // TODO: Add assertions on result
    }

    /**
     * Method under test: {@link JwtAuthenticationController#healthCheck()}
     */
    @Test
    void testHealthCheck() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/health-check");
        MockMvcBuilders.standaloneSetup(jwtAuthenticationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("auth-Ok"));
    }

    /**
     * Method under test: {@link JwtAuthenticationController#healthCheck()}
     */
    @Test
    void testHealthCheck2() throws Exception {
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/health-check");
        getResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(jwtAuthenticationController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("auth-Ok"));
    }
}

