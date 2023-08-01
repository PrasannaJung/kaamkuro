package com.kaamkuro.kaamkuro.controller;

import com.kaamkuro.kaamkuro.dto.EmployeeDto;
import com.kaamkuro.kaamkuro.entity.Employee;
import com.kaamkuro.kaamkuro.service.EmployeeService;
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
public class ProfileController {
    private final EmployeeService employeeService;
    @GetMapping("/employee/profile")
    public String getProfile(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        Employee profile = employeeService.getEmployee(email);
        System.out.println(profile.getEmail());
        model.addAttribute("profile",profile);
        return "Employee profile";
    }
    @PostMapping("/employee/profile/update")
    public String updateProfile(@ModelAttribute EmployeeDto employeeDto){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        Employee existingProfile = employeeService.getEmployee(email);
        existingProfile.setEmail(employeeDto.getEmail());
        existingProfile.setPassword(employeeDto.getPassword());
        existingProfile.setAge(employeeDto.getAge());
        existingProfile.setId(employeeDto.getId());
        existingProfile.setDesc(employeeDto.getMydescription());
        existingProfile.setName(employeeDto.getName());
        existingProfile.setProfession(employeeDto.getProfession());
        existingProfile.setSkill(employeeDto.getSkill());
        existingProfile.setMainLang(employeeDto.getLanguage());
        employeeService.update(existingProfile);
        return "redirect:/employee/profile";
    }
}
