package com.kaamkuro.kaamkuro.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

@Entity
@Table(name="users")
@Setter
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthUser {
    @Id
    @SequenceGenerator(name="sequence_usr",allocationSize = 1,sequenceName="gen_sequence_usr")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "gen_sequence_usr")
    private Integer id;

    private String email;
    private String password;
    private String role;

}
