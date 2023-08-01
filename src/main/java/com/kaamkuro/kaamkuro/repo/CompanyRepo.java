package com.kaamkuro.kaamkuro.repo;

import com.kaamkuro.kaamkuro.entity.Company;
import com.kaamkuro.kaamkuro.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompanyRepo extends JpaRepository<Company,Integer> {
    Optional<Company> findByEmail(String email);
}
