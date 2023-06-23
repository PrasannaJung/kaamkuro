package com.kaamkuro.kaamkuro.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
}
