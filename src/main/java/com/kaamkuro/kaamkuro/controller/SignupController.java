package com.kaamkuro.kaamkuro.controller;

import com.kaamkuro.kaamkuro.dto.CompanyProfileDto;
import com.kaamkuro.kaamkuro.dto.EmployeeDto;
import com.kaamkuro.kaamkuro.dto.NewUser;
import com.kaamkuro.kaamkuro.repo.CompanyRepo;
import com.kaamkuro.kaamkuro.service.AuthUserService;
import com.kaamkuro.kaamkuro.service.CompanyService;
import com.kaamkuro.kaamkuro.service.EmployeeService;
import com.kaamkuro.kaamkuro.utils.PasswordEncoderUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class SignupController {
    private final EmployeeService employeeService;

    private final AuthUserService authUserService;
    private final CompanyService companyService;

    @PostMapping("/signup/save")
    public String postUser(@ModelAttribute NewUser newUser){
        System.out.println("Signup controller hit");
        System.out.println(newUser.getEmail());
        System.out.println(newUser.getPassword());
        System.out.println(newUser.getRole());
        authUserService.saveUser(newUser);
        EmployeeDto employeeDto = new EmployeeDto();
        CompanyProfileDto companyProfileDto = new CompanyProfileDto();
        if(newUser.getRole().equals("ROLE_EMPLOYEE")){
            employeeDto.setEmail(newUser.getEmail());
            employeeDto.setPassword(newUser.getPassword());
            employeeService.addEmployee(employeeDto);
        }else{
            companyProfileDto.setEmail(newUser.getEmail());
            companyProfileDto.setPassword(newUser.getPassword());
            companyService.addCompany(companyProfileDto);
        }
        return "redirect:/login";
    }

}
