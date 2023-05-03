package com.example.entitymapping.oneToOne.controller;

import com.example.entitymapping.oneToOne.Constants;
import com.example.entitymapping.oneToOne.model.Employee;
import com.example.entitymapping.oneToOne.model.EmployeeDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OneToOneController {
    @PostMapping(Constants.EMPLOYEES)
    public ResponseEntity<Object> insertEmployee(@RequestBody EmployeeDto employeeDto) {
        Employee employee = new Employee();

        employee.setName(employeeDto.getName());
        employee.setId(employeeDto.getId());
        employee.setEmail(employeeDto.getEmail());


    }
}
