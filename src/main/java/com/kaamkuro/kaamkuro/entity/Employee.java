package com.kaamkuro.kaamkuro.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    @SequenceGenerator(name="sequence_employee",allocationSize = 1,sequenceName="gen_sequence_employee")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "gen_sequence_employee")
    private Integer id;

    @Column(name="employee_name")
    private String name;

    @Column(name="employee_email")
    private String email;

    @Column(name="employee_password")
    private String password;

    @Column(name="employee_age")
    private Integer age;

    @Column(name="employee_lang")
    private String mainLang;

    @Column(name="employee_skill")
    private String skill;

    @Column(name="employee_profession")
    private String profession;

    @Column(name="employee_description")
    private String desc;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
}
