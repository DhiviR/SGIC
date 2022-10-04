package com.school.student.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.student.model.Student;
import com.school.student.repositories.StudentRepository;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public void saveStudent(Student student) {
	studentRepository.save(student);
    }

}
