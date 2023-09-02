package com.freeuniproject.emisapp.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class StudentGrade {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "studentgradecomponent_id_sequence_generator")
    @SequenceGenerator(name = "studentgradecomponent_id_sequence_generator", sequenceName = "STUDENTGRADECOMPONENT_ID_SEQUENCE", allocationSize = 1)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "gradeComponent_id")
    private GradeComponent gradeComponent;


    @ManyToOne
    @JoinColumn(name = "studentCourse_id")
    private StudentCourse studentCourse;

    private double mark;

}
