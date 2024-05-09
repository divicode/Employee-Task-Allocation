package com.cts.authorization.config;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {JwtRequestFilter.class})
@ExtendWith(SpringExtension.class)
class JwtRequestFilterTest {
    @Autowired
    private JwtRequestFilter jwtRequestFilter;

    /**
     * Method under test: {@link JwtRequestFilter#doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testDoFilterInternal() throws IOException, ServletException {
        // TODO: Complete this test.
        //   Reason: F009 Internal error.
        //   java.lang.StackOverflowError
        //   Please contact Diffblue through the appropriate support channel
        //   (https://www.diffblue.com/support/) providing details about this error.

        // Arrange
        // TODO: Populate arranged inputs
        HttpServletRequest request = null;
        HttpServletResponse response = null;
        FilterChain chain = null;

        // Act
        this.jwtRequestFilter.doFilterInternal(request, response, chain);

        // Assert
        // TODO: Add assertions on result
    }
}

