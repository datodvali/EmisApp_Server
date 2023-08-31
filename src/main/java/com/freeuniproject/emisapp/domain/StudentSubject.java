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
public class StudentSubject {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "studentsubject_id_sequence_generator")
    @SequenceGenerator(name = "studentsubject_id_sequence_generator", sequenceName = "STUDENTSUBJECT_ID_SEQUENCE", allocationSize = 1)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    private int semester;

    @Enumerated(EnumType.STRING)
    private Grade grade;

    private double markInSubject;

    private boolean passed;

    @OneToMany(mappedBy = "studentSubject")
    private List<StudentGrade> gradeComponents;

}
