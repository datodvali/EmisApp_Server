package com.freeuniproject.emisapp.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class CourseInfoDTO {

    private Long courseId;

    private String subjectCode;

    private String subjectName;

    private boolean available;

}
