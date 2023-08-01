package com.kaamkuro.kaamkuro.repo;

import com.kaamkuro.kaamkuro.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee,Integer> {
}
