package com.kaamkuro.kaamkuro.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
    private String name;
    private String email;
    private String mydescription;
    private String language;
    private Integer age;
    private String skill;
    private String profession;
    
}
