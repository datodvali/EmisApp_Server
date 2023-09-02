package com.freeuniproject.emisapp.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class CourseDTO {

    private Long id;

    private String courseName;

    private String subjectCode;

    private String subjectDescription;

    private int year;

    private int semester;

    private int studentsRegistered;

    private int studentsLimit;

    private int credits;

    private boolean finished;

}
