package com.freeuniproject.emisapp.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@NoArgsConstructor
@Setter
@Getter
@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_id_sequence_generator")
    @SequenceGenerator(name = "course_id_sequence_generator", sequenceName = "COURSE_ID_SEQUENCE", allocationSize = 1)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "subject_id", referencedColumnName = "id")
    private Subject subject;

    @ColumnDefault("0")
    private int studyYear;

    private int semester;

    private int studentsRegistered;

    private int studentLimit;

    private int credits;

    private boolean finished;

}
