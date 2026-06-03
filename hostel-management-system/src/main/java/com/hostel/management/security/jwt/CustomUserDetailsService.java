package com.hostel.management.security.jwt;

import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import com.hostel.management.entity.User;
import com.hostel.management.repository.UserRepository;

@Service
public class CustomUserDetailsService
        implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(
            UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(
            String username)
            throws UsernameNotFoundException {

        User user = userRepository
                .findByUsername(username)
                .orElseThrow(() ->
                        new UsernameNotFoundException(
                                "User not found"));

        return org.springframework.security.core.userdetails
                .User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .authorities("USER")
                .build();
    }
}