package com.freeuniproject.emisapp.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class TeacherCourseDTO {

    private Long teacherId;

    private Long subjectId;

    private String subjectName;

    private String subjectCode;

}
