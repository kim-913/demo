package com.example.demo.student;

import com.example.demo.student.exception.BadRequestException;
import com.example.demo.student.exception.StudentNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;
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
        Boolean existsEmail = studentRepository.selectExistsEmail(student.getEmail());
        if(existsEmail){
            throw new BadRequestException("Email for" + student.getEmail() + "is taken");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        if(!studentRepository.existsById((studentId))) {
            throw new StudentNotFoundException("Student with id" + studentId + "does not exist");
        }
        studentRepository.deleteById(studentId);
    }
}
