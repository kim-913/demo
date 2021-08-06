package com.example.demo.student;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@AllArgsConstructor
@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public List<Student> getAllStudent(){
        return studentRepository.findAll();
    }

    public void addStudent(Student student) {
        // no validation
        // check if email is taken, if it is, throw error
        // debugging, test why doesn't adding work
        //System.out.print(student);
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        studentRepository.deleteById(studentId);
    }
}
