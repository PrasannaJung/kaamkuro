package com.kaamkuro.kaamkuro.service.impl;

import com.kaamkuro.kaamkuro.dto.ApplyJobDto;
import com.kaamkuro.kaamkuro.entity.ApplyJob;
import com.kaamkuro.kaamkuro.repo.ApplyJobRepo;
import com.kaamkuro.kaamkuro.service.ApplyJobService;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

//public class ApplyJobServiceImpl implements ApplyJobService {
//    private final ApplyJobRepo applyJobRepo;
//
//    @Override
//    public void saveData(ApplyJobDto applyJobDto) throws IOException {
//        ApplyJob applyJob = new ApplyJob();
//        applyJob.setId(applyJobDto.getId());
//        applyJob.setFullname(applyJobDto.getFullname());
//        applyJob.setEmail(applyJobDto.getEmail());
//        applyJob.setPhoneNumber(applyJobDto.getPhoneNumber());
//        applyJob.setCv(applyJobDto.getCv());
//        applyJob.setCountry(applyJobDto.getCountry());
//        applyJob.setDescription(applyJobDto.getDescription());
//        applyJob.setJobposition(applyJobDto.getJobposition());
        //applyJob.save(applyJobDto);

//    }

//    @Override
//    public List<ApplyJob> getData() {
//        return applyJobRepo.findAll();
//    }
//
//    @Override
//    public void deleteById(Integer id) {
//        applyJobRepo.deleteById(id);
//    }
//
//    @Override
//    public Optional<ApplyJob> getById(Integer id) {
//        return applyJobRepo.findById(id);
//    }
//
//
//    @Override
//    public List<ApplyJob> getAllData() {
//        return applyJobRepo.findAll();
//    }
//
//    @Override
//    public Optional<ApplyJob> fetchById(Integer id) {
//        return applyJobRepo.findById(id);
//    }

//    @Override
//    public ApplyJobDto getByIdNotOpt(Integer id) {
//        return applyJobRepo.findById(id).orElseThrow(() -> new RuntimeException("not found"));
//    }
//}
