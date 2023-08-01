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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class CompanyProfileController {
    private final CompanyService companyService;

    @GetMapping("/company/profile")
    public String getCompProfile(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        Company profile = companyService.getCompanyEmail(email);
        System.out.println(profile.getEmail());
        model.addAttribute("profile",profile);
        return "CompanyProf";
    }
    @PostMapping("/company/profile/update")
    public String updateCompany(@ModelAttribute CompanyProfileDto companyProfileDto){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        Company company= companyService.getCompanyEmail(email);
        company.setName(companyProfileDto.getName());
        company.setEmail(companyProfileDto.getEmail());
        company.setAddress(companyProfileDto.getAddress());
        company.setDescription(companyProfileDto.getDescription());
        company.setPhone(companyProfileDto.getPhone());
        company.setId(companyProfileDto.getId());
        company.setPassword(companyProfileDto.getPassword());
        companyService.updateCompany(company);
        return "redirect:/company/profile";
    }

}
