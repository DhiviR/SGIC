package com.school.student.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.student.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
