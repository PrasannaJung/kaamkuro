package com.kaamkuro.kaamkuro.entity;


import jakarta.persistence.*;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="users_role")
public class Role {
    @Id
    @SequenceGenerator(name="roles_seq_gen",allocationSize = 1,sequenceName = "roles_seq")
    @GeneratedValue(generator = "roles_seq_gen",strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name="role",nullable = false)
    private String name;

}
