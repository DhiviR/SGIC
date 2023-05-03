package com.sgic.employee.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sgic.employee.Contants;
import com.sgic.employee.entities.Employee;
import com.sgic.employee.entities.EmployeeDetails;
import com.sgic.employee.service.EmployeeDto;
import com.sgic.employee.service.EmployeeService;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @PostMapping(Contants.EMPLOYEE)
    public ResponseEntity<Object> createIncomingSample(@RequestBody EmployeeDto employeeDto) {
	Employee employee = new Employee();
	employee.setId(employeeDto.getId());
	employee.setFirstName(employeeDto.getFirstName());
	employee.setLastName(employeeDto.getLastName());
	employee.setEmail(employeeDto.getEmail());
//		//EmployeeDetailDto employeeDetailDto = new EmployeeDetailDto();
	EmployeeDetails employeeDetails = new EmployeeDetails();
	employeeDetails.setId(employeeDto.getEmployeeDetail().getId());
	employeeDetails.setAddress(employeeDto.getEmployeeDetail().getAddress());
	employeeDetails.setDepartment(employeeDto.getEmployeeDetail().getDepartment());
	employeeDetails.setGender(employeeDto.getEmployeeDetail().getGender());
	employeeDetails.setJobTitle(employeeDto.getEmployeeDetail().getJobTitle());
	employeeDetails.setSalary(employeeDto.getEmployeeDetail().getSalary());
	employee.setEmployeeDetail(employeeDetails);
	employeeService.saveEmployee(employee);
	return ResponseEntity.ok("Saved Successfully!");
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<Object> getEmployeeById(@PathVariable Long id) {

	return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }

    @GetMapping("/hello")
    public Map<String, String> callAsyncMethod() {
	Map<String, String> map = new HashMap<String, String>();
	map.put("message", "Hello");

	map.put("message1", "Hello-world");
	return map; // returns empty braces
    }
}
