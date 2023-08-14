package com.kaamkuro.kaamkuro.controller;

import com.kaamkuro.kaamkuro.dto.JobDto;
import com.kaamkuro.kaamkuro.entity.Job;
import com.kaamkuro.kaamkuro.service.ApplyJobService;
import com.kaamkuro.kaamkuro.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class JobController {
    private final JobService jobService;
    private final ApplyJobService applyJobService;
    @GetMapping("/Jobs")
    public String getAllJobs(Model model){
        model.addAttribute("jobDto", new JobDto());
        model.addAttribute("items",jobService.getAllData().stream().map(res->
                Job.builder()
                        .id(res.getId())
                        .jobPosition(res.getJobPosition())
                        .companyName(res.getCompanyName())
                        .salary(res.getSalary())
                        .jobType(res.getJobType())
                        .build()));
        return "/EmployeeJobs.html";
    }
    @GetMapping("/table")
    public String getDataView(Model model) {
        model.addAttribute("items", applyJobService.getData());
        model.addAttribute("currentuser", getCurrentUser());
        return "table.html";
    }
    public String getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentemail = authentication.getName();
        return currentemail;
    }
}
