package com.freeuniproject.emisapp.domain;

import jakarta.persistence.*;

@Entity
public class GradeComponent {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gradecomponent_id_sequence_generator")
    @SequenceGenerator(name = "gradecomponent_id_sequence_generator", sequenceName = "GRADECOMPONENT_ID_SEQUENCE", allocationSize = 1)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    private String name;

    private double totalPoints;

}
