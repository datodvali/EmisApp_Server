package com.freeuniproject.emisapp.service;

import com.freeuniproject.emisapp.dto.*;
import com.freeuniproject.emisapp.exception.EmisException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CourseService {

    Page<CourseInfoForStudentDTO> filterCoursesForStudent(Long studentId, String subjectName, Pageable pageable);

    SyllabusDTO getSyllabus(Long courseId);

    CourseDetailsForTeacherDTO getCourseDetailsForTeacher(Long courseId) throws EmisException;

    CourseDetailsForStudentDTO getCourseDetailsForStudent(Long courseId, Long studentId) throws EmisException;

}
