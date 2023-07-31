package com.kaamkuro.kaamkuro.dto;

import com.kaamkuro.kaamkuro.entity.Job;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JobDto {
    private Integer id;

    @NotEmpty (message = "position can't be empty")
    private String jobPosition;

    @NotEmpty (message = "salary can't be empty")
    private String salary;

    @NotEmpty (message = "companyName can't be empty")
    private String companyName;

    @NotEmpty (message = "jobType can't be empty")
    private String jobType;

    public JobDto(Job job){
        this.id = job.getId();
        this.jobPosition = job.getJobPosition();
        this.salary = job.getSalary();
        this.companyName = job.getCompanyName();
        this.jobType = job.getJobType();
    }
}
