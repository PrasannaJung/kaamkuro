package com.kaamkuro.kaamkuro.service.impl;

import com.kaamkuro.kaamkuro.dto.CustomUserDetails;
import com.kaamkuro.kaamkuro.entity.AuthUser;
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
        String EMAIL = username;
        AuthUser retrievedUser = authUserRepo.findByEmail(username).orElse(null);
        System.out.println(retrievedUser);
        if (retrievedUser == null) {
            throw new UsernameNotFoundException(String.format("USER WITH EMAIL is NOT FOUND", username));
        }
        return new CustomUserDetails(retrievedUser);
    }
}