package com.example.demo.student;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

//expose resources clients can consumer
@RestController
@RequestMapping(path = "api/v1/students")

@AllArgsConstructor
public class StudentController {

    private final StudentService studentService;

    //create API end points
    //@RequestMapping(path = "/api/v1/students")
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
        // return students;
        return studentService.getAllStudent();
    }

    // get a mapping and return request
    @PostMapping
    public void addStudent(@RequestBody Student student){
        studentService.addStudent(student);
    }
}