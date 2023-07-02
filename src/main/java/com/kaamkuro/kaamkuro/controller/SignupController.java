package com.kaamkuro.kaamkuro.controller;

import com.kaamkuro.kaamkuro.dto.NewUser;
import com.kaamkuro.kaamkuro.service.AuthUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class SignupController {

    private final AuthUserService authUserService;

    @PostMapping("/signup/save")
    public String postUser(@ModelAttribute NewUser newUser){
        System.out.println("Signup controller hit");
        System.out.println(newUser.getEmail());
        System.out.println(newUser.getPassword());
        System.out.println(newUser.getRole());
        authUserService.saveUser(newUser);

        return "redirect:/login";
    }

}
