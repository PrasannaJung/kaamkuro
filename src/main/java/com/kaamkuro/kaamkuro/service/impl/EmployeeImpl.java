package com.kaamkuro.kaamkuro.service.impl;

import com.kaamkuro.kaamkuro.dto.EmployeeDto;
import com.kaamkuro.kaamkuro.entity.Employee;
import com.kaamkuro.kaamkuro.repo.EmployeeRepo;
import com.kaamkuro.kaamkuro.service.EmployeeService;
import com.kaamkuro.kaamkuro.utils.PasswordEncoderUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeImpl implements EmployeeService {
    private final EmployeeRepo employeeRepo;
    @Override
    public void addEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee();
        employee.setEmail(employeeDto.getEmail());
        employee.setPassword(PasswordEncoderUtil.getInstance().encode(employeeDto.getPassword()));
        employeeRepo.save(employee);
    }

    @Override
    public Employee getEmployee(String email) {
        return employeeRepo.findByEmail(email).get();
    }

    @Override
    public void update(Employee existingProfile) {
        employeeRepo.save(existingProfile);
    }
}
