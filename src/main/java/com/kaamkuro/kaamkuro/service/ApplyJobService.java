package com.kaamkuro.kaamkuro.service;

import com.kaamkuro.kaamkuro.dto.ApplyJobDto;
import com.kaamkuro.kaamkuro.entity.ApplyJob;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface ApplyJobService {
    void saveData (ApplyJobDto applyJobDto) throws IOException;

    List<ApplyJob> getData();

    void deleteById(Integer id);

    Optional<ApplyJob> getById(Integer id);


    List<ApplyJob> getAllData();

    Optional<ApplyJob> fetchById(Integer id);

    ApplyJob getByIdNotOpt(Integer id);
}
