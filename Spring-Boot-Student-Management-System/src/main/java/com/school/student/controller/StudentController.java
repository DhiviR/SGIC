package com.school.student.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
    @GetMapping("/hello")
    public String sayHello() {
	return "Hello";
    }

//    @GetMapping
//    public 
}
