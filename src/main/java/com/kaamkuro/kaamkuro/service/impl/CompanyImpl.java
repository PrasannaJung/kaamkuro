package com.kaamkuro.kaamkuro.service.impl;

import com.kaamkuro.kaamkuro.dto.CompanyProfileDto;
import com.kaamkuro.kaamkuro.entity.Company;
import com.kaamkuro.kaamkuro.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompanyImpl implements CompanyService {


    @Override
    public void addCompany(CompanyProfileDto addCompany) {
        Company company= new Company();
        company.setEmail("Comp");
    }
}
