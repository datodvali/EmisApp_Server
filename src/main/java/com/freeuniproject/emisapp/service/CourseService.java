package com.freeuniproject.emisapp.service;

import com.freeuniproject.emisapp.dto.CourseDTO;
import com.freeuniproject.emisapp.dto.CourseInfoDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CourseService {

    Page<CourseInfoDTO> getCourses(Long studentId, String subjectName, Pageable pageable);

    CourseDTO getCourse(Long id);
}
