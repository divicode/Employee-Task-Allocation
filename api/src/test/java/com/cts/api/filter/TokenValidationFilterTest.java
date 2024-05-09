package com.cts.api.filter;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.http.HttpHeaders;
import org.springframework.http.codec.support.DefaultServerCodecConfigurer;
import org.springframework.http.server.reactive.ServerHttpRequestDecorator;
import org.springframework.mock.http.server.reactive.MockServerHttpResponse;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebSession;
import org.springframework.web.server.adapter.DefaultServerWebExchange;
import org.springframework.web.server.i18n.AcceptHeaderLocaleContextResolver;
import org.springframework.web.server.session.WebSessionManager;
import reactor.core.publisher.Mono;

class TokenValidationFilterTest {
    /**
     * Method under test: {@link TokenValidationFilter#filter(ServerWebExchange, GatewayFilterChain)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testFilter() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IndexOutOfBoundsException: Index: 0
        //       at java.util.Collections$EmptyList.get(Collections.java:4456)
        //       at com.cts.api.filter.TokenValidationFilter.filter(TokenValidationFilter.java:28)
        //   In order to prevent filter(ServerWebExchange, GatewayFilterChain)
        //   from throwing IndexOutOfBoundsException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   filter(ServerWebExchange, GatewayFilterChain).
        //   See https://diff.blue/R013 to resolve this issue.

        TokenValidationFilter tokenValidationFilter = new TokenValidationFilter(null);
        ServerHttpRequestDecorator serverHttpRequestDecorator = mock(ServerHttpRequestDecorator.class);
        when(serverHttpRequestDecorator.getHeaders()).thenReturn(new HttpHeaders());
        when(serverHttpRequestDecorator.getId()).thenReturn("https://example.org/example");
        WebSessionManager webSessionManager = mock(WebSessionManager.class);
        when(webSessionManager.getSession((ServerWebExchange) any())).thenReturn((Mono<WebSession>) mock(Mono.class));
        MockServerHttpResponse response = new MockServerHttpResponse();
        DefaultServerCodecConfigurer codecConfigurer = new DefaultServerCodecConfigurer();
        tokenValidationFilter.filter(new DefaultServerWebExchange(serverHttpRequestDecorator, response, webSessionManager,
                codecConfigurer, new AcceptHeaderLocaleContextResolver()), null);
    }

    /**
     * Method under test: {@link TokenValidationFilter#filter(ServerWebExchange, GatewayFilterChain)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testFilter2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.cts.api.filter.TokenValidationFilter.filter(TokenValidationFilter.java:25)
        //   In order to prevent filter(ServerWebExchange, GatewayFilterChain)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   filter(ServerWebExchange, GatewayFilterChain).
        //   See https://diff.blue/R013 to resolve this issue.

        (new TokenValidationFilter(null)).filter(null, null);
    }

    /**
     * Method under test: {@link TokenValidationFilter#filter(ServerWebExchange, GatewayFilterChain)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testFilter3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.cts.api.filter.TokenValidationFilter.filter(TokenValidationFilter.java:26)
        //   In order to prevent filter(ServerWebExchange, GatewayFilterChain)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   filter(ServerWebExchange, GatewayFilterChain).
        //   See https://diff.blue/R013 to resolve this issue.

        TokenValidationFilter tokenValidationFilter = new TokenValidationFilter(null);
        DefaultServerWebExchange defaultServerWebExchange = mock(DefaultServerWebExchange.class);
        when(defaultServerWebExchange.getRequest()).thenReturn(null);
        tokenValidationFilter.filter(defaultServerWebExchange, null);
    }
}

