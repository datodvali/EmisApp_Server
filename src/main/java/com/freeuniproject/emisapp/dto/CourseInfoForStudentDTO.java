package com.freeuniproject.emisapp.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CourseInfoForStudentDTO extends CourseInfoDTO {

    private Boolean available;

    private Boolean necessary;

}
