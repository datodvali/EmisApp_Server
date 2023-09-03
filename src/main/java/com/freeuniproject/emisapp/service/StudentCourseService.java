package com.freeuniproject.emisapp.service;

import com.freeuniproject.emisapp.dto.CourseInfoForStudentDTO;
import com.freeuniproject.emisapp.dto.StudentCourseDTO;
import com.freeuniproject.emisapp.dto.StudentGradeDTO;

import java.util.List;

public interface StudentCourseService {

    List<List<StudentCourseDTO>> getStudentCourses(Long studentId);

    List<StudentCourseDTO> getStudentsInfoForCourse(Long classId);

    List<StudentGradeDTO> getStudentGradeInfo(Long studentId, Long courseId);

    void registerStudentForCourse(Long studentId, Long courseId);

    List<CourseInfoForStudentDTO> getRegisteredCoursesForStudent(Long studentId);

    void deleteStudentCourse(Long studentId, Long courseId);
}
