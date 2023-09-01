package com.freeuniproject.emisapp.service;

import com.freeuniproject.emisapp.dto.StudentCourseDTO;
import com.freeuniproject.emisapp.dto.StudentCourseCardDTO;

import java.util.List;

public interface StudentCourseService {

    List<List<StudentCourseDTO>> getStudentCourses(Long studentId);

    List<StudentCourseDTO> getStudentsInfoForCourse(Long classId);
}
