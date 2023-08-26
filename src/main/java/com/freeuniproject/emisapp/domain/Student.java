package com.freeuniproject.emisapp.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
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

    @OneToOne(mappedBy = "student")
    private StudentFinances finances;

    @OneToMany(mappedBy = "student")
    private List<StudentSubject> subjects;

}
