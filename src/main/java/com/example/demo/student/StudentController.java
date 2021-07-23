package com.example.demo.student;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

//expose resources clients can consumer
@RestController
@AllArgsConstructor
//@RequestMapping(path = "api/v1/students")
public class StudentController {
    private final StudentService studentService;

    //create API end points
    @RequestMapping(path = "/api/v1/students")
    @GetMapping
    public List<Student> getAllStudents() {
        // List<Student> students = Arrays.asList(
        //         new Student(1L,
        //                 "Kim",
        //                 "kziruo@gmail.com",
        //                 Gender.MALE),
        //         new Student(2L,
        //                 "Tracy",
        //                 "tracy@gmail.com",
        //                 Gender.FEMALE)
        // );
        return studentService.getAllStudents();
    }
}