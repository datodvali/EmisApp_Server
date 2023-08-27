package com.freeuniproject.emisapp.domain;

import jakarta.persistence.*;

@Entity
public class TeacherPosition {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "teacherposition_id_sequence_generator")
    @SequenceGenerator(name = "t_id_sequence_generator", sequenceName = "SUBJECT_ID_SEQUENCE", allocationSize = 1)
    private Long id;

    @Column(unique = true)
    private String name;

}
