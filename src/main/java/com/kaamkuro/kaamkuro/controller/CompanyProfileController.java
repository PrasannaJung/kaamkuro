package com.kaamkuro.kaamkuro.controller;

import com.kaamkuro.kaamkuro.dto.CompanyProfileDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class CompanyProfileController {
    @PostMapping("/company/profile/")
    public String updateCompany(@ModelAttribute CompanyProfileDto companyProfileDto){
        return "redirect:/company/prfile";
    }

}
