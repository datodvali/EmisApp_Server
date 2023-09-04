package com.freeuniproject.emisapp.service;


import com.freeuniproject.emisapp.domain.DashboardComponent;
import com.freeuniproject.emisapp.domain.StudentStatus;
import com.freeuniproject.emisapp.dto.StudentDTO;
import com.freeuniproject.emisapp.exception.EmisException;

import java.util.List;

public interface StudentService {

    StudentDTO getStudent(Long id) throws EmisException;

    void updateStatus(Long id, StudentStatus studentStatus);

    List<DashboardComponent> getViewablePages(Long id);

    void updatePassword(Long id, String password);

}
