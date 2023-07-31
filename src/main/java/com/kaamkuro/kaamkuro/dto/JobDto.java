package com.kaamkuro.kaamkuro.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JobDto {
    private String jobname;
    private String description;
    private Integer Salary;
}
