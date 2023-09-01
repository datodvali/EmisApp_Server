package com.freeuniproject.emisapp.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_id_sequence_generator")
    @SequenceGenerator(name = "student_id_sequence_generator", sequenceName = "STUDENT_ID_SEQUENCE", allocationSize = 1)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Enumerated(EnumType.STRING)
    private StudentStatus status;

    @Enumerated(EnumType.STRING)
    private DegreeLevel degreeLevel;

    private int semester;

    private int credits;

    private double gpa;

    private int yearEnrolled;

    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private StudentFinances finances;

    @OneToMany(mappedBy = "student", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
    private List<StudentCourse> subjects;

}
