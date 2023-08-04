package com.kaamkuro.kaamkuro.controller;

import com.kaamkuro.kaamkuro.dto.JobDto;
import com.kaamkuro.kaamkuro.entity.Job;
import com.kaamkuro.kaamkuro.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class JobController {
    private final JobService jobService;
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
}
