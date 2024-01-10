package org.demointernetshop.anotations;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.test.context.support.WithSecurityContextFactory;

import java.util.Collections;

public class WithMockAdminSecurityContextFactory implements WithSecurityContextFactory<WithMockAdmin> {
    @Override
    public SecurityContext createSecurityContext(WithMockAdmin withMockAdmin) {

        SecurityContext context = SecurityContextHolder.createEmptyContext();

        User principal = new User(withMockAdmin.username(), "password",
                Collections.singleton(new SimpleGrantedAuthority("ROLE_ADMIN")));

        Authentication auth = new UsernamePasswordAuthenticationToken(principal, "password", principal.getAuthorities());

        context.setAuthentication(auth);


        return context;
    }
}
