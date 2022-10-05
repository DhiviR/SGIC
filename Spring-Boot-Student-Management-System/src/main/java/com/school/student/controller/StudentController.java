package com.school.student.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.school.student.model.Student;
import com.school.student.model.StudentDto;
import com.school.student.service.StudentService;

@RestController
public class StudentController {

    Logger logger = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    StudentService studentService;

    @GetMapping("/hello")
    public String sayHello() {
	logger.error("Accessed hello end point successfully");
	return "Hello";
    }

    @PostMapping("/insert")
    public ResponseEntity<String> insertStudent(@RequestBody StudentDto studentDto) {
	Student student = new Student();
	logger.info("Entered into insert method");

	student.setFirstName(studentDto.getFirstName());
	student.setLastName(studentDto.getLastName());
	student.setGrade(studentDto.getGrade());
	student.setGender(studentDto.getGender());
	student.setAddress(studentDto.getAddress());
	student.setTelephone(studentDto.getTelephone());
	studentService.saveStudent(student);

	return new ResponseEntity<String>("Saved successfully!", HttpStatus.OK);
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<Object> getStudent(@PathVariable Long id) {
	return ResponseEntity.ok(studentService.getStudent(id));
    }
}
