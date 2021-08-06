package com.example.demo.student;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

//import javax.persistence.*;
// don't put @Data here because fields aren't final
@ToString
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Student {
    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "student_sequence",
            strategy = GenerationType.SEQUENCE)
    private Long id;
    // fix the blank input
    @NotBlank
    @Column(nullable = false)
    private String name;
    @Email
    @Column(nullable = false, unique = true)
    private String email;
    // fix the type of gender
    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Gender gender;

    public Student(String name, String email, Gender gender) {
        this.name = name;
        this.email = email;
        this.gender = gender;
    }
}
// package com.example.demo.student;
//
// import lombok.*;
//
// // don't put @Data here because fields aren't final
// @ToString
// @Getter
// @Setter
// @EqualsAndHashCode
// @NoArgsConstructor
// @AllArgsConstructor
// public class Student {
//     private Long id;
//     private String name;
//     private String email;
//     private Gender gender;
// }