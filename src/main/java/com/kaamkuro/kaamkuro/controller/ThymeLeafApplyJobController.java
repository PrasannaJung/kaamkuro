package com.kaamkuro.kaamkuro.controller;

import com.kaamkuro.kaamkuro.dto.ApplyJobDto;
import com.kaamkuro.kaamkuro.entity.ApplyJob;
import com.kaamkuro.kaamkuro.service.ApplyJobService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
@RequestMapping("th-admin")
@RequiredArgsConstructor
public class ThymeLeafApplyJobController {
    private final ApplyJobService applyJobService;

    @GetMapping("/table")
    public String getDataView(Model model) {
        model.addAttribute("items", applyJobService.getData());
        model.addAttribute("currentuser", getCurrentUser());
        return "table.html";
    }


    @GetMapping("/make")
    public String getFormPage(Model model) {
        model.addAttribute("applyJobDto", new ApplyJobDto());
        return "applyjob.html";
    }

    @PostMapping("/save")
    public String saveData(@Valid ApplyJobDto applyJobDto) throws IOException {
        applyJobService.saveData(applyJobDto);
        return "redirect:/home";
    }

    public String getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentemail = authentication.getName();
        return currentemail;
    }

}
