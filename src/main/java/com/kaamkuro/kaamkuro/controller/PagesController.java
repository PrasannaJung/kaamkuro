package com.kaamkuro.kaamkuro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PagesController {
    @GetMapping("/home")
    public String getHomePage(){
        return "homepage";
    }

    @GetMapping("/user/profile")
    public String getProfilePage(){
        return "profile";
    }

    @GetMapping("/user/resume")
    public String getResumePage(){
        return "Resume";
    }

    @GetMapping("/company-profile")
    public String getCompanyPage(){
        return "CompanyProf";
    }

    @GetMapping("/signup")
    public String getSignupPage(){
        return "signup";
    }

    @GetMapping("/login")
    public String getLoginPage(){return "login"; }

    @GetMapping("/delete-job")
    public String getDeleteJobPage(){return "deletejoblisting"; }



}
