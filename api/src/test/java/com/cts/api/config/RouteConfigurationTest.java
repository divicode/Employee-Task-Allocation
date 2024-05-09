package com.cts.api.config;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.cts.api.filter.TokenValidationFilter;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.cloud.gateway.handler.predicate.PathRoutePredicateFactory;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class RouteConfigurationTest {
    /**
     * Method under test: {@link RouteConfiguration#routes(RouteLocatorBuilder)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testRoutes() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R004 No meaningful assertions found.
        //   Diffblue Cover was unable to create an assertion.
        //   Make sure that fields modified by routes(RouteLocatorBuilder)
        //   have package-private, protected, or public getters.
        //   See https://diff.blue/R004 to resolve this issue.

        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //   In order to prevent routes(RouteLocatorBuilder)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   routes(RouteLocatorBuilder).
        //   See https://diff.blue/R013 to resolve this issue.

        RouteConfiguration routeConfiguration = new RouteConfiguration(new TokenValidationFilter(null));
        routeConfiguration.routes(new RouteLocatorBuilder(new AnnotationConfigReactiveWebApplicationContext())).getRoutes();
    }

    /**
     * Method under test: {@link RouteConfiguration#routes(RouteLocatorBuilder)}
     */
    @Test
    void testRoutes2() throws BeansException {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R004 No meaningful assertions found.
        //   Diffblue Cover was unable to create an assertion.
        //   Make sure that fields modified by routes(RouteLocatorBuilder)
        //   have package-private, protected, or public getters.
        //   See https://diff.blue/R004 to resolve this issue.

        RouteConfiguration routeConfiguration = new RouteConfiguration(new TokenValidationFilter(null));
        AnnotationConfigApplicationContext annotationConfigApplicationContext = mock(
                AnnotationConfigApplicationContext.class);
        when(annotationConfigApplicationContext.getBean((Class<PathRoutePredicateFactory>) any()))
                .thenReturn(new PathRoutePredicateFactory());
        routeConfiguration.routes(new RouteLocatorBuilder(annotationConfigApplicationContext)).getRoutes();
        verify(annotationConfigApplicationContext, atLeast(1)).getBean((Class<PathRoutePredicateFactory>) any());
    }
}

