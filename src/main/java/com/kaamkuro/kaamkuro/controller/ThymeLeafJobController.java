package com.kaamkuro.kaamkuro.controller;

import com.kaamkuro.kaamkuro.dto.JobDto;
import com.kaamkuro.kaamkuro.entity.Job;
import com.kaamkuro.kaamkuro.service.JobService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;

@Controller
@RequestMapping("/th-job")
@RequiredArgsConstructor
public class ThymeLeafJobController {
    private final JobService jobService;

    @GetMapping("/create")
    public String getFormPage(Model model){
        model.addAttribute("jobDto", new JobDto());
        model.addAttribute("items",jobService.getAllData().stream().map(res->
                Job.builder()
                        .id(res.getId())
//                        .item_description(res.getItem_description())
//                        .item_name(res.getItem_name())
//                        .item_price(res.getItem_price())
//                        .item_rating(res.getItem_rating())
                        .jobPosition(res.getJobPosition())
                        .companyName(res.getCompanyName())
                        .salary(res.getSalary())
                        .jobType(res.getJobType())
                        .build()));
        return "/jobListing.html";
    }

    @PostMapping("/save")
    public String saveData(@Valid JobDto jobDto) throws IOException {
        jobService.saveData(jobDto);
        return "redirect:/th-job/create";
    }
    @GetMapping("edit/{id}")
    public String getUpdateData(@PathVariable Integer id, Model model){
        Job job =jobService.getByIdNotOpt(id);
        model.addAttribute("adminPagePojo",new JobDto(job));
        return "/jobListing.html";
    }
    @GetMapping("/delete/{id}")
    public String getDeleteData(@PathVariable Integer id) {
        jobService.deleteById(id);
        return "redirect:/th-job/create";
    }
}
