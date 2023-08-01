package com.kaamkuro.kaamkuro.controller;

import com.kaamkuro.kaamkuro.entity.Employee;
import com.kaamkuro.kaamkuro.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class ProfileController {
    private final EmployeeService employeeService;
    @GetMapping("/employee/profile")
    public String getProfile(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        Employee profile = employeeService.getEmployee(email);
        System.out.println(profile.getEmail());
        return "Employee profile";
    }
}
