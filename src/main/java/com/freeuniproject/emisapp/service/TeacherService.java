package com.freeuniproject.emisapp.service;

import com.freeuniproject.emisapp.domain.DashboardComponent;
import com.freeuniproject.emisapp.domain.TeacherStatus;
import com.freeuniproject.emisapp.dto.TeacherDTO;

import java.util.List;


public interface TeacherService {

    TeacherDTO getTeacher(Long teacherId);

    List<DashboardComponent> getViewablePages(Long id);

    void updateStatus(Long id, TeacherStatus status);

}
