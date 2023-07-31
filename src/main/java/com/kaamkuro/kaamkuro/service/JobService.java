package com.kaamkuro.kaamkuro.service;

import com.kaamkuro.kaamkuro.dto.JobDto;
import com.kaamkuro.kaamkuro.entity.Job;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface JobService {
    void saveData (JobDto jobDto) throws IOException;

    List<Job> getData();

    void deleteById(Integer id);

    Optional<Job> getById(Integer id);

    void dropById(Integer id);

    List<Job> getAllData();

    Optional<Job> fetchById(Integer id);

    Job getByIdNotOpt(Integer id);
}
