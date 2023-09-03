package com.freeuniproject.emisapp.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Setter
@Getter
@Entity
public class StudentCourse {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "studentcourse_id_sequence_generator")
    @SequenceGenerator(name = "studentcourse_id_sequence_generator", sequenceName = "STUDENTCOURSE_ID_SEQUENCE", allocationSize = 1)
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

    @Column(columnDefinition = "boolean default false")
    private boolean passed;

    @OneToMany(mappedBy = "studentCourse", cascade = CascadeType.ALL)
    private List<StudentGrade> gradeComponents;

}
