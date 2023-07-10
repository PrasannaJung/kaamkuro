package com.kaamkuro.kaamkuro.dto;

import com.kaamkuro.kaamkuro.entity.AuthUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

public class CustomUserDetails implements UserDetails {

    private AuthUser authUser;

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
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
