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
public class AuthUser {
    @Id
    @SequenceGenerator(name="sequence_usr",allocationSize = 1,sequenceName="gen_sequence_usr")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "gen_sequence_usr")
    private Integer id;

    private String email;
    private String password;
    private String role;

}
