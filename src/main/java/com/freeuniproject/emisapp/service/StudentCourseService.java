package com.freeuniproject.emisapp.service;

import com.freeuniproject.emisapp.dto.CourseInfoForStudentDTO;
import com.freeuniproject.emisapp.dto.StudentCourseDTO;
import com.freeuniproject.emisapp.dto.StudentGradeDTO;
import com.freeuniproject.emisapp.exception.EmisException;

import java.util.List;

public interface StudentCourseService {

    List<List<StudentCourseDTO>> getStudentCourses(Long studentId) throws EmisException;

    List<StudentGradeDTO> getStudentGradeInfo(Long studentId, Long courseId);

    void registerStudentForCourse(Long studentId, Long courseId) throws EmisException;

    List<CourseInfoForStudentDTO> getRegisteredCoursesForStudent(Long studentId);

    void deleteStudentCourse(Long studentId, Long courseId);

}
