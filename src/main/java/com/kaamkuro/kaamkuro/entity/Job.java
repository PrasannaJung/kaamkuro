package com.kaamkuro.kaamkuro.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Job {

    @Id
    @SequenceGenerator(name = "sequence_job",allocationSize = 1,sequenceName = "gen_sequence_job")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "gen_sequence_job")
    private Integer id;
//    @Column(name="jobname")
//    private String jobname;

    @Column(name="job_position")
    private String jobPosition;
    @Column(name="job_salary")
    private String salary;
    @Column(name="company_name")
    private String companyName;
    @Column(name = "Job_type")
    private String jobType;

























    @ManyToOne
    @JoinColumn(name="company_id")
    private Company company;



    @OneToMany(mappedBy = "job",cascade = CascadeType.ALL)
    private List<Application> applicationsList;

}
