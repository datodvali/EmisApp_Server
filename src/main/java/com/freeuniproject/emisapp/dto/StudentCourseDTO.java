package com.freeuniproject.emisapp.dto;

import com.freeuniproject.emisapp.domain.Grade;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class StudentCourseDTO {

    private Long id;

    private long studentId;

    private long courseId;

    private String courseName;

    private String subjectCode;

    private double mark;

    private Grade grade;

    private String description;

}
