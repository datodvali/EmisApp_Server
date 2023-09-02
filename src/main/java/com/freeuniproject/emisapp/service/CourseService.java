package com.freeuniproject.emisapp.service;

import com.freeuniproject.emisapp.domain.Syllabus;
import com.freeuniproject.emisapp.dto.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CourseService {

    Page<CourseInfoDTO> getCourses(Long studentId, String subjectName, Pageable pageable);

    CourseDTO getCourse(Long courseId);

    SyllabusDTO getSyllabus(Long courseId);

    CourseDetailsForTeacherDTO getCourseDetailsForTeacher(Long courseId);

    CourseDetailsForStudentDTO getCourseDetailsForStudent(Long courseId, Long studentId);

}
