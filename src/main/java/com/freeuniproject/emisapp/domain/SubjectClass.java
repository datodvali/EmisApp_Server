package com.freeuniproject.emisapp.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
@Entity
public class SubjectClass {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "subjectclass_id_sequence_generator")
    @SequenceGenerator(name = "subjectclass_id_sequence_generator", sequenceName = "SUBJECTCLASS_ID_SEQUENCE", allocationSize = 1)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "subject_id", referencedColumnName = "id")
    private Subject subject;

    private int year;

    private int semester;

    private int studentsRegistered;

    private int studentLimit;

}
