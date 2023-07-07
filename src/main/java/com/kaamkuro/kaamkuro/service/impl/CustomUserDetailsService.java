package com.kaamkuro.kaamkuro.service.impl;

import com.kaamkuro.kaamkuro.repo.AuthUserRepo;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final AuthUserRepo authUserRepo;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.authUserRepo.findByEmail(username).orElseThrow(() -> new EntityNotFoundException("User not found."));
    }
}