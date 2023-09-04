package com.freeuniproject.emisapp.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class CourseInfoDTO {

    private Long courseId;

    private String subjectCode;

    private String subjectName;

    private List<String> prerequisites;

}
