package com.kaamkuro.kaamkuro.repo;

import com.kaamkuro.kaamkuro.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepo extends JpaRepository<Job,Integer> {
}
