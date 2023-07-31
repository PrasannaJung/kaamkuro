package com.kaamkuro.kaamkuro.dto;

import com.kaamkuro.kaamkuro.entity.AuthUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.*;


public class CustomUserDetails implements UserDetails {
    private final AuthUser authUser;

    public CustomUserDetails(AuthUser authUser){
        this.authUser = authUser;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> rolesList = new ArrayList<>();
        rolesList.add(new SimpleGrantedAuthority(this.authUser.getRole()));
        return rolesList;
    }

    @Override
    public String getPassword() {
        return this.authUser.getPassword();
    }

    @Override
    public String getUsername() {
        return this.authUser.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
