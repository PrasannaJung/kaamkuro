package com.kaamkuro.kaamkuro.service;

import com.kaamkuro.kaamkuro.dto.EmployeeDto;
import com.kaamkuro.kaamkuro.entity.Employee;

public interface EmployeeService {
    void addEmployee(EmployeeDto employeeDto);

    Employee getEmployee(String email);

    void update(Employee existingProfile);
}
