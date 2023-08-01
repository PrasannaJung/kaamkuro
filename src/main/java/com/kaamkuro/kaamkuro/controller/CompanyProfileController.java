package com.kaamkuro.kaamkuro.controller;

import com.kaamkuro.kaamkuro.dto.CompanyProfileDto;
import com.kaamkuro.kaamkuro.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class CompanyProfileController {
    private final CompanyService companyService;
    @PostMapping("/company/profile/")
    public String updateCompany(@ModelAttribute CompanyProfileDto companyProfileDto){
        companyService.addCompany(companyProfileDto);
        return "redirect:/company/prfile";
    }

}
