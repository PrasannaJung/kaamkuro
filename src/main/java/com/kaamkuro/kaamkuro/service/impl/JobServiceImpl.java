package com.kaamkuro.kaamkuro.service.impl;

import com.kaamkuro.kaamkuro.dto.JobDto;
import com.kaamkuro.kaamkuro.entity.Job;
import com.kaamkuro.kaamkuro.repo.JobRepo;
import com.kaamkuro.kaamkuro.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class JobServiceImpl implements JobService {
    private final JobRepo jobRepo;

    @Override
    public void saveData(JobDto jobDto) throws IOException {
        Job job = new Job();
        job.setId(jobDto.getId());
        job.setJobPosition(jobDto.getJobPosition());
        job.setSalary(jobDto.getSalary());
        job.setCompanyName(jobDto.getCompanyName());
        job.setJobType(jobDto.getJobType());
        jobRepo.save(job);
    }

    @Override
    public List<Job> getData() {
        return jobRepo.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        jobRepo.deleteById(id);
    }

    @Override
    public Optional<Job> getById(Integer id) {
//        return Optional.empty();
        return jobRepo.findById(id);
    }

    @Override
    public void dropById(Integer id) {
        jobRepo.deleteById(id);
    }

    @Override
    public List<Job> getAllData() {
//        return null;
        return jobRepo.findAll();
    }

    @Override
    public Optional<Job> fetchById(Integer id) {
//        return Optional.empty();
        return jobRepo.findById(id);
    }

    @Override
    public Job getByIdNotOpt(Integer id) {
//        return null;
        return jobRepo.findById(id).orElseThrow(()->new RuntimeException("not found"));
    }
}
