package com.freeuniproject.emisapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class StudentCourseCardDTO {

    private List<List<StudentCourseDTO>> coursesBySemester;

}