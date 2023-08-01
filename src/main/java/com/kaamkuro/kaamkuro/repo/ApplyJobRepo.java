package com.kaamkuro.kaamkuro.repo;

import com.kaamkuro.kaamkuro.entity.ApplyJob;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplyJobRepo extends JpaRepository<ApplyJob,Integer> {
}
