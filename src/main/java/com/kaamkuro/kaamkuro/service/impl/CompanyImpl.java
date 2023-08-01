package com.kaamkuro.kaamkuro.service.impl;

import com.kaamkuro.kaamkuro.dto.CompanyProfileDto;
import com.kaamkuro.kaamkuro.dto.EmployeeDto;
import com.kaamkuro.kaamkuro.entity.Company;
import com.kaamkuro.kaamkuro.entity.Employee;
import com.kaamkuro.kaamkuro.repo.CompanyRepo;
import com.kaamkuro.kaamkuro.service.CompanyService;
import com.kaamkuro.kaamkuro.utils.PasswordEncoderUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompanyImpl implements CompanyService {

    private final CompanyRepo companyRepo;
//    @Override
//    public void addCompany(CompanyProfileDto addCompany) {
//        Company company= new Company();
//        company.setName(company.getName());
//        company.setEmail(company.getEmail());
//        company.setAddress(company.getAddress());
//        company.setDescription(company.getDescription());
//        company.setPhone(company.getPhone());
//        company.setId(company.getId());
//        companyRepo.save(company);
//    }
    @Override
    public void addCompany(CompanyProfileDto companyProfileDto) {
        Company company = new Company();
        company.setEmail(companyProfileDto.getEmail());
        company.setPassword(PasswordEncoderUtil.getInstance().encode(companyProfileDto.getPassword()));
        companyRepo.save(company);
    }
    @Override
    public Company getCompanyEmail(String email) {
        Company company = new Company();
        return companyRepo.findByEmail(email).get();
    }
}
