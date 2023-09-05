package com.freeuniproject.emisapp.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.util.Set;

@Setter
@Getter
@Entity
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "teacher_id_sequence_generator")
    @SequenceGenerator(name = "teacher_id_sequence_generator", sequenceName = "TEACHER_ID_SEQUENCE", allocationSize = 1)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(referencedColumnName = "name")
    private TeacherPosition position;

    @Enumerated(EnumType.STRING)
    private TeacherStatus status;

    @ColumnDefault("0.0")
    private double salary;

    @OneToMany(mappedBy = "teacher", fetch = FetchType.LAZY)
    private Set<TeacherCourse> subjects;

}
