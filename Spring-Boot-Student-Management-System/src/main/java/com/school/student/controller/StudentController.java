package com.school.student.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.school.student.Constants;
import com.school.student.model.Student;
import com.school.student.model.StudentDto;
import com.school.student.service.StudentServiceImplementation;

@RestController
public class StudentController {

    Logger logger = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    StudentServiceImplementation studentService;

    @GetMapping(Constants.GREETING)
    public String sayHello() {
	logger.info("Accessed hello end point successfully");
	return "Hello there!";
    }

    @PostMapping(Constants.STUDENTS)
    public ResponseEntity<Object> insertStudent(@RequestBody StudentDto studentDto) {
	Student student = new Student();
	logger.info("Entered into insert method");

	student.setFirstName(studentDto.getFirstName());
	student.setLastName(studentDto.getLastName());
	student.setGrade(studentDto.getGrade());
	student.setGender(studentDto.getGender());
	student.setAddress(studentDto.getAddress());
	student.setTelephone(studentDto.getTelephone());
	studentService.saveStudent(student);

	return ResponseEntity.ok("Saved successfully!");
    }

    @GetMapping(Constants.STUDENT)
    public ResponseEntity<Object> getStudent(@PathVariable Long id) {
	return ResponseEntity.ok(studentService.getStudent(id));
    }

    @PutMapping(Constants.STUDENT)
    public ResponseEntity<Object> updateStudent(@PathVariable("id") Long id, @RequestBody StudentDto studentDto) {
	Student student = new Student();
	student.setStudentId(id);
	student.setFirstName(studentDto.getFirstName());
	student.setLastName(studentDto.getLastName());
	student.setGrade(studentDto.getGrade());
	student.setGender(studentDto.getGender());
	student.setAddress(studentDto.getAddress());
	student.setTelephone(studentDto.getTelephone());
	if (studentService.updateStudent(student) == "Updated") {
	    return ResponseEntity.ok("Updated successfully!");
	} else {
	    return ResponseEntity.ok("Saved successfully!");
	}

    }

    @DeleteMapping(Constants.STUDENT)
    public ResponseEntity<HttpStatus> deleteStudent(@PathVariable Long id) {
	try {
	    studentService.deleteStudent(id);
	    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	} catch (Exception e) {
	    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
    }

}
