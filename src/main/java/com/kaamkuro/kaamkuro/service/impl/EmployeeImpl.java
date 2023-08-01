package com.kaamkuro.kaamkuro.service.impl;

import com.kaamkuro.kaamkuro.dto.EmployeeDto;
import com.kaamkuro.kaamkuro.entity.Employee;
import com.kaamkuro.kaamkuro.service.EmployeeService;
import com.kaamkuro.kaamkuro.utils.PasswordEncoderUtil;
import org.springframework.stereotype.Service;

@Service
public class EmployeeImpl implements EmployeeService {
    @Override
    public void addEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee();
        employee.setEmail(employeeDto.getEmail());
        employee.setPassword(PasswordEncoderUtil.getInstance().encode(employeeDto.getPassword()));
    }
}
