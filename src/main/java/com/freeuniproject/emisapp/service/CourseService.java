package com.freeuniproject.emisapp.service;

import com.freeuniproject.emisapp.dto.CourseDTO;
import com.freeuniproject.emisapp.dto.CourseDetailsDTO;
import com.freeuniproject.emisapp.dto.CourseInfoDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CourseService {

    Page<CourseInfoDTO> getCourses(Long studentId, String subjectName, Pageable pageable);

    CourseDTO getCourse(Long id);

    CourseDetailsDTO getCourseDetails(Long courseId);

}
