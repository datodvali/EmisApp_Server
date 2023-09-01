package com.freeuniproject.emisapp.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class CourseDetailsDTO {

    CourseDTO course;

    List<StudentInfoDTO> students;

}
