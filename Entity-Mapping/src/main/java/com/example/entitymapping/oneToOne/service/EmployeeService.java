package com.example.entitymapping.oneToOne.service;

import com.example.entitymapping.oneToOne.model.Employee;
import com.example.entitymapping.oneToOne.model.EmployeeDto;

public interface EmployeeService {
    void saveEmployee(Employee employee);
    EmployeeDto getEmployee(long id);
}
