package com.freeuniproject.emisapp.service;

import com.freeuniproject.emisapp.domain.DashboardComponent;
import com.freeuniproject.emisapp.domain.TeacherStatus;
import com.freeuniproject.emisapp.dto.TeacherDTO;
import com.freeuniproject.emisapp.dto.TeacherSubjectCardDTO;
import com.freeuniproject.emisapp.dto.TeacherSubjectDTO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface TeacherService {

    TeacherDTO getTeacher(Long teacherId);

    TeacherDTO getTeacherByEmail(String email);

    List<DashboardComponent> getViewablePages(Long id);

    void updateStatus(Long id, TeacherStatus status);

    void updatePhoneNumber(Long id, String phoneNumber);
}
