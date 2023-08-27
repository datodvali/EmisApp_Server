package com.freeuniproject.emisapp.domain;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
@Entity
public class TeacherSubject {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "teachersubject_id_sequence_generator")
    @SequenceGenerator(name = "teachersubject_id_sequence_generator", sequenceName = "TEACHERSUBJECT_ID_SEQUENCE", allocationSize = 1)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @ManyToOne
    @JoinColumn(name = "subjectClass_id")
    private SubjectClass subjectClass;

}