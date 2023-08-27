package com.freeuniproject.emisapp.service;

import com.freeuniproject.emisapp.domain.DashboardComponent;
import com.freeuniproject.emisapp.dto.TeacherDTO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface TeacherService {

    TeacherDTO getTeacher(Long teacherId);

    TeacherDTO getTeacherByEmail(String email);

    List<DashboardComponent> getViewablePages(Long id);

}
