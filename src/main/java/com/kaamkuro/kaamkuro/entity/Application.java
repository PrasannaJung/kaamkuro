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
public class Application {
    @Id
    @SequenceGenerator(name = "sequence_application", allocationSize = 1,sequenceName ="gen_sequence_application" )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_sequence_application")
    private String id;

    @Column(name="application_status")
    private String status;

    @Column(name ="application_deadline")
    private String deadline;

    @ManyToOne
    @JoinColumn(name="job_id")
    private Job job;

}
