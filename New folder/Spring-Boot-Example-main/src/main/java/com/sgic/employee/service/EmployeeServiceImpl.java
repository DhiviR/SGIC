package com.sgic.employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.employee.entities.Employee;
import com.sgic.employee.repositories.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
@Autowired
EmployeeRepository employeeRepository;

	@Override
	public void saveEmployee(Employee employee) {
		employeeRepository.save(employee);
	}

	@Override
	public EmployeeDto getEmployeeById(Long id) {
		// TODO Auto-generated method stub
		Employee employee=employeeRepository.findById(id).get();
		EmployeeDto employeeDto=new EmployeeDto();
		employeeDto.setId(employee.getId());
		employeeDto.setFirstName(employee.getFirstName());
		employeeDto.setLastName(employee.getLastName());
		employeeDto.setEmail(employee.getEmail());
		EmployeeDetailDto detailDto=new EmployeeDetailDto();
		detailDto.setId(employee.getEmployeeDetail().getId());
		detailDto.setAddress(employee.getEmployeeDetail().getAddress());
		detailDto.setDepartment(employee.getEmployeeDetail().getDepartment());
		detailDto.setGender(employee.getEmployeeDetail().getGender());
		detailDto.setJobTitle(employee.getEmployeeDetail().getJobTitle());
		detailDto.setSalary(employee.getEmployeeDetail().getSalary());
		employeeDto.setEmployeeDetail(detailDto);
		return employeeDto;
	}

}
