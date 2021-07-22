package com.example.demo.student;

import lombok.*;

// don't put @Data here because fields aren't final
@ToString
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
//@AllArgsConstructor
public class Student {
    public Student(Long id, String name, String email, Gender gender) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.gender = gender;
    }

    private Long id;
    private String name;
    private String email;
    private Gender gender;
}