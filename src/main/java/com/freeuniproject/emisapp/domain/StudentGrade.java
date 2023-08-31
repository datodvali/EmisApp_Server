package com.freeuniproject.emisapp.domain;

import jakarta.persistence.*;

@Entity
public class StudentGrade {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "studentgradecomponent_id_sequence_generator")
    @SequenceGenerator(name = "studentgradecomponent_id_sequence_generator", sequenceName = "STUDENTGRADECOMPONENT_ID_SEQUENCE", allocationSize = 1)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "gradecomponent_id")
    private GradeComponent gradeComponent;

    @ManyToOne
    @JoinColumn(name = "studentsubject_id")
    private StudentSubject studentSubject;

    private double mark;

}
