package com.freeuniproject.emisapp.service;


import com.freeuniproject.emisapp.domain.DashboardComponent;
import com.freeuniproject.emisapp.domain.StudentStatus;
import com.freeuniproject.emisapp.dto.StudentDTO;

import java.util.List;

public interface StudentService {

    StudentDTO getStudent(Long id);

    StudentDTO getStudentByEmail(String email);

    void updateStudentStatus(Long id, StudentStatus studentStatus);

    void updateStudentPhoneNumber(Long id, String phoneNumber);

    List<DashboardComponent> getViewablePages(Long id);

}
