package com.kaamkuro.kaamkuro.service;


import com.kaamkuro.kaamkuro.dto.CompanyProfileDto;
import com.kaamkuro.kaamkuro.entity.Company;
import com.kaamkuro.kaamkuro.entity.Employee;

public interface CompanyService {
    void addCompany(CompanyProfileDto addCompany);
    Company getCompanyEmail(String email);

    void updateCompany(Company companyProfile);
}
