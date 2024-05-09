package com.cts.authorization.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.springframework.security.core.GrantedAuthority;

class MyUserDetailsTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link MyUserDetails#MyUserDetails(User)}
     *   <li>{@link MyUserDetails#isAccountNonExpired()}
     *   <li>{@link MyUserDetails#isAccountNonLocked()}
     *   <li>{@link MyUserDetails#isCredentialsNonExpired()}
     *   <li>{@link MyUserDetails#isEnabled()}
     * </ul>
     */
    @Test
    void testConstructor() {
        MyUserDetails actualMyUserDetails = new MyUserDetails(new User("janedoe", "iloveyou"));
        assertTrue(actualMyUserDetails.isAccountNonExpired());
        assertTrue(actualMyUserDetails.isAccountNonLocked());
        assertTrue(actualMyUserDetails.isCredentialsNonExpired());
        assertTrue(actualMyUserDetails.isEnabled());
    }

    /**
     * Method under test: {@link MyUserDetails#getAuthorities()}
     */
    @Test
    void testGetAuthorities() {
        Collection<? extends GrantedAuthority> actualAuthorities = (new MyUserDetails(new User("janedoe", "iloveyou")))
                .getAuthorities();
        assertEquals(1, actualAuthorities.size());
        assertEquals("ROLE_ADMIN", ((List<? extends GrantedAuthority>) actualAuthorities).get(0).getAuthority());
    }

    /**
     * Method under test: {@link MyUserDetails#getPassword()}
     */
    @Test
    void testGetPassword() {
        assertEquals("iloveyou", (new MyUserDetails(new User("janedoe", "iloveyou"))).getPassword());
    }

    /**
     * Method under test: {@link MyUserDetails#getPassword()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetPassword2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.cts.authorization.model.MyUserDetails.getPassword(MyUserDetails.java:26)
        //   In order to prevent getPassword()
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getPassword().
        //   See https://diff.blue/R013 to resolve this issue.

        (new MyUserDetails(null)).getPassword();
    }

    /**
     * Method under test: {@link MyUserDetails#getUsername()}
     */
    @Test
    void testGetUsername() {
        assertEquals("janedoe", (new MyUserDetails(new User("janedoe", "iloveyou"))).getUsername());
    }

    /**
     * Method under test: {@link MyUserDetails#getUsername()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetUsername2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.cts.authorization.model.MyUserDetails.getUsername(MyUserDetails.java:32)
        //   In order to prevent getUsername()
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getUsername().
        //   See https://diff.blue/R013 to resolve this issue.

        (new MyUserDetails(null)).getUsername();
    }
}

