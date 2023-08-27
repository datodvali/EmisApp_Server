package com.freeuniproject.emisapp.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@NoArgsConstructor
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

    private double salary;

    @OneToMany(mappedBy = "teacher", fetch = FetchType.LAZY)
    private Set<TeacherSubject> subjects;

}
