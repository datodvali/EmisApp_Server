package com.freeuniproject.emisapp.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Setter
@Getter
public class CourseDetailsForTeacherDTO extends CourseDetailsDTO {

    List<StudentInfoDTO> students;

}
