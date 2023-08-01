package com.kaamkuro.kaamkuro.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.*;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Company {
    @Id
    @SequenceGenerator(name = "sequence_company",allocationSize = 1,sequenceName = "gen_sequence_company")
    @GeneratedValue( strategy = GenerationType.SEQUENCE,generator = "gen_sequence_company")
    private Integer id;
    @Column(name = "company_name")
    private String name;
    @Column(name = "company_address")
    private String address;
    @Column(name = "company_email")
    private String email;
    @Column(name = "company_phone")
    private String phone;
    @Column(name = "password")
    private String password;
    @Column(name="company_desc")
    private String description;
}
