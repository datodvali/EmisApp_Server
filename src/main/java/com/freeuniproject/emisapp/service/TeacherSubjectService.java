package com.freeuniproject.emisapp.service;

import com.freeuniproject.emisapp.dto.TeacherSubjectCardDTO;
import com.freeuniproject.emisapp.dto.TeacherSubjectDTO;

import java.util.List;

public interface TeacherSubjectService {

    TeacherSubjectCardDTO getSubjectCard(Long id);

    List<TeacherSubjectDTO> getTeachingHistory(Long id);

}
