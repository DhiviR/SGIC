package com.school.student.service;

import com.school.student.model.Student;
import com.school.student.model.StudentDto;

public interface StudentService {
    void saveStudent(Student student);

    StudentDto getStudent(Long id);

    String updateStudent(Student sudent);

    void deleteStudent(Long id);
}
