package com.freeuniproject.emisapp.service;

import com.freeuniproject.emisapp.dto.CourseInfoDTO;
import com.freeuniproject.emisapp.dto.TeacherCourseDTO;

import java.util.List;

public interface TeacherCourseService {

    List<CourseInfoDTO> getTeacherCourses(Long id);

    List<TeacherCourseDTO> getTeachingHistory(Long id);

}
