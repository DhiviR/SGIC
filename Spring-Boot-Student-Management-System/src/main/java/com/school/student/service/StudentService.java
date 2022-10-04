package com.school.student.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.student.model.Student;
import com.school.student.model.StudentDto;
import com.school.student.repositories.StudentRepository;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public void saveStudent(Student student) {
	studentRepository.save(student);
    }

    public StudentDto getStudent(Long id) {
	Student student = studentRepository.findById(id).get();
	StudentDto studentDto = new StudentDto();

	studentDto.setStudentId(student.getStudentId());
	studentDto.setFirstName(student.getFirstName());
	studentDto.setLastName(student.getLastName());
	studentDto.setGrade(student.getGrade());
	studentDto.setGender(student.getGender());
	studentDto.setAddress(student.getAddress());
	studentDto.setTelephone(student.getTelephone());

	return studentDto;
    }

}
