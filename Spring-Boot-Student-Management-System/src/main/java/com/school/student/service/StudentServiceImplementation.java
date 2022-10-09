package com.school.student.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.student.model.Student;
import com.school.student.model.StudentDto;
import com.school.student.repositories.StudentRepository;

@Service
public class StudentServiceImplementation implements StudentService {
    @Autowired
    StudentRepository studentRepository;

    @Override
    public void saveStudent(Student student) {
	studentRepository.save(student);
    }

    @Override
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

    @Override
    public String updateStudent(Student student) {
	Optional<Student> studentData = studentRepository.findById(student.getStudentId());

	if (studentData.isPresent()) {
	    Student existingStudent = studentData.get();
//	    existingStudent.setStudentId(student.getStudentId());
	    if (student.getFirstName() != null) {
		existingStudent.setFirstName(student.getFirstName());
	    }

	    if (student.getLastName() != null) {
		existingStudent.setLastName(student.getLastName());
	    }
	    if (student.getGrade() != 0) {
		existingStudent.setGrade(student.getGrade());
	    }
	    if (student.getGender() != null) {
		existingStudent.setGender(student.getGender());
	    }
	    if (student.getAddress() != null) {
		existingStudent.setAddress(student.getAddress());
	    }
	    if (student.getTelephone() != null) {
		existingStudent.setTelephone(student.getTelephone());
	    }

	    studentRepository.save(existingStudent);
	    return "Updated";
	} else {
	    studentRepository.save(student);
	    return "Added";
	}

    }

    @Override
    public void deleteStudent(Long id) {
	studentRepository.deleteById(id);
    }

}
