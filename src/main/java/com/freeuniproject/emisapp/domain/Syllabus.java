package com.freeuniproject.emisapp.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Syllabus {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "syllabus_id_sequence_generator")
    @SequenceGenerator(name = "syllabus_id_sequence_generator", sequenceName = "SYLLABUS_ID_SEQUENCE", allocationSize = 1)
    private Long id;

    @OneToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @Lob
    private byte[] content;

}
