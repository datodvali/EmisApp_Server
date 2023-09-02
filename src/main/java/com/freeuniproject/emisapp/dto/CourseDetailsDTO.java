package com.freeuniproject.emisapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Setter
@Getter
public class CourseDetailsDTO {

    CourseDTO course;

    List<StudentInfoDTO> students;

}
