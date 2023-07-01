package com.kaamkuro.kaamkuro.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users_tbl")
@Setter
@Getter
public class AuthUser {

    @Id
    @SequenceGenerator(name="sequence_usr",allocationSize = 1,sequenceName="gen_sequence_usr")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "gen_sequence_usr")
    private Integer id;

    private String email;
    private String password;
    private int role;

}
