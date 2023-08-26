package com.freeuniproject.emisapp.service;

import com.freeuniproject.emisapp.dto.SubjectCardDTO;

public interface StudentSubjectService {

    SubjectCardDTO getStudentSubjectCard(Long studentId);

}
