package com.freeuniproject.emisapp.dto;

import com.freeuniproject.emisapp.domain.Grade;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class StudentSubjectDTO {

    private Long id;

    private long studentId;

    private SubjectDTO subject;

    private int semester;

    private Grade grade;

    private double markInSubject;

}
