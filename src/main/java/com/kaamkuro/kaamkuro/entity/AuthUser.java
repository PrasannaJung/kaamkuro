package com.kaamkuro.kaamkuro.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

@Entity
@Table(name = "users",uniqueConstraints = {
        @UniqueConstraint(name="UNIQUE_user_email",columnNames = "email")
})
@Setter
@Getter
public class AuthUser implements UserDetails {
    @Id
    @SequenceGenerator(name="sequence_usr",allocationSize = 1,sequenceName="gen_sequence_usr")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "gen_sequence_usr")
    private Integer id;

    private String email;
    private String password;

    @ManyToOne
    private Role role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<Role> roles=new ArrayList<>();
        roles.add(this.getRole());
        System.out.println(roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList()));
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());

    }

    @Override
    public String getUsername() {
        return this.email;
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
