package com.group19.flightfinder.Service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // In a real application, you would fetch user details from a database or another external system.
        if ("oskarok".equals(username)) {
            UserBuilder builder = User.withDefaultPasswordEncoder();
            builder.username("oskarok");
            builder.password("oskarkotyla11");
            builder.roles("USER");
            return builder.build();
        } else {
            throw new UsernameNotFoundException("User not found.");
        }
    }
}
