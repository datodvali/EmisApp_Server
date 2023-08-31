package com.freeuniproject.emisapp.service;

import com.freeuniproject.emisapp.dto.StudentSubjectCardDTO;
import com.freeuniproject.emisapp.dto.StudentSubjectDTO;

import java.util.List;

public interface StudentSubjectService {

    StudentSubjectCardDTO getSubjectCard(Long studentId);

    List<StudentSubjectDTO> getStudentsInfoForClass(Long classId);
}
