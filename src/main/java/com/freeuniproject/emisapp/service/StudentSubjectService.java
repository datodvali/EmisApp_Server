package com.freeuniproject.emisapp.service;

import com.freeuniproject.emisapp.dto.StudentSubjectCardDTO;

public interface StudentSubjectService {

    StudentSubjectCardDTO getSubjectCard(Long studentId);

}
