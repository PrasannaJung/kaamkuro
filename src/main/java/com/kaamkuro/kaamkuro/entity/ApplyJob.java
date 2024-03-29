package com.kaamkuro.kaamkuro.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApplyJob {

    @Id
    @SequenceGenerator(name = "users_seq_gen", sequenceName = "users_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "users_seq_gen", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "fullname", nullable = false)
    private String fullname;

    @Column(name = "jobposition", nullable = false)
    private String jobposition;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "country", nullable = false)
    private String country;

    @Column(name = "phoneNumber", nullable = false)
    private String phoneNumber;


//    @Column(name = "cv", nullable = true)
//    private String cv;


    @Column(name = "email", nullable = false)
    private String email;


    @Column(name = "description", nullable = false)
    private String description;
}

