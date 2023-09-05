package com.freeuniproject.emisapp.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class TeacherPosition {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "teacherposition_id_sequence_generator")
    @SequenceGenerator(name = "teacherposition_id_sequence_generator", sequenceName = "TEACHERPOSITION_ID_SEQUENCE", allocationSize = 1)
    private Long id;

    @Column(unique = true)
    private String name;

}
