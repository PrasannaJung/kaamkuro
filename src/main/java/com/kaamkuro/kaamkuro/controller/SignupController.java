package com.kaamkuro.kaamkuro.controller;

import com.kaamkuro.kaamkuro.dto.NewUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignupController {

    @GetMapping("/signup")
    public String getSignupPage(){
        return "signup";
    }

    @PostMapping("/save")
    public String postUser(@ModelAttribute NewUser newUser){
        System.out.println(newUser.getEmail());
        System.out.println(newUser.getPassword());
        System.out.println(newUser.getRole());
        return "redirect:/signup";
    }

}
