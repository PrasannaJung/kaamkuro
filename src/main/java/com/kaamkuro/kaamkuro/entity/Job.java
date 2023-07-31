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
public class Job {

    @Id
    @SequenceGenerator(name = "sequence_job",allocationSize = 1,sequenceName = "gen_sequence_job")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "gen_sequence_job")
    private Integer id;

    @Column(name="job_description")
    private String description;

    @Column(name="job_salary")
    private Integer salary;

    @ManyToOne
    @JoinColumn(name="company_id")
    private Company company;

    @OneToMany(mappedBy = "job",cascade = CascadeType.ALL)
    private List<Application> applicationsList;

}
