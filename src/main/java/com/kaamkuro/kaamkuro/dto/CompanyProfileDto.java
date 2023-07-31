package com.kaamkuro.kaamkuro.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CompanyProfileDto {
    private String email;
    private String phone;
    private String name;
    private String description;
    private String address;
}
