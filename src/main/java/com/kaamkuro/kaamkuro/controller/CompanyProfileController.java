package com.kaamkuro.kaamkuro.controller;

import com.kaamkuro.kaamkuro.dto.CompanyProfileDto;
import com.kaamkuro.kaamkuro.entity.Company;
import com.kaamkuro.kaamkuro.entity.Employee;
import com.kaamkuro.kaamkuro.repo.CompanyRepo;
import com.kaamkuro.kaamkuro.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class CompanyProfileController {
    private final CompanyService companyService;
    private final CompanyRepo companyRepo;
    @PostMapping("/company/profile/")
    public String updateCompany(@ModelAttribute CompanyProfileDto companyProfileDto){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        Company company= companyService.getCompanyEmail(email);
        company.setName(company.getName());
        company.setEmail(company.getEmail());
        company.setAddress(company.getAddress());
        company.setDescription(company.getDescription());
        company.setPhone(company.getPhone());
        company.setId(company.getId());
        company.setPassword(company.getPassword());
        companyRepo.save(company);
        companyService.addCompany(companyProfileDto);
        return "redirect:/company/prfile";
    }

}
