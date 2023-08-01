package com.kaamkuro.kaamkuro.service.impl;

import com.kaamkuro.kaamkuro.dto.EmployeeDto;
import com.kaamkuro.kaamkuro.entity.Employee;
import com.kaamkuro.kaamkuro.service.EmployeeService;
import org.springframework.stereotype.Service;

@Service
public class EmployeeImpl implements EmployeeService {
    @Override
    public void addEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee();
    }
}
