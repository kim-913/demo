package com.example.demo.student;

import com.example.demo.student.exception.BadRequestException;
import com.example.demo.student.exception.StudentNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

//expose resources clients can consumer
@RestController
@RequestMapping(path = "api/v1/students")

public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

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
        //throw new IllegalStateException("opps, error");
        return studentService.getAllStudent();
    }

    // get a mapping and return request
    @PostMapping
    // make sure requestBody is valid
    public void addStudent(@Valid @RequestBody Student student) throws BadRequestException {
        studentService.addStudent(student);
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(
            @PathVariable("studentId") Long studentId) throws StudentNotFoundException {
        studentService.deleteStudent(studentId);
    }
}