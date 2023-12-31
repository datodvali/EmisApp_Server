package com.freeuniproject.emisapp.impl;

import com.freeuniproject.emisapp.repository.StudentGradeRepository;
import com.freeuniproject.emisapp.service.StudentGradeService;
import org.springframework.stereotype.Service;

@Service
public class StudentGradeServiceImpl implements StudentGradeService {

    private final StudentGradeRepository studentGradeRepository;

    public StudentGradeServiceImpl(StudentGradeRepository studentGradeRepository) {
        this.studentGradeRepository = studentGradeRepository;
    }

    @Override
    public void updateStudentMark(long studentGradeId, double mark) {
        studentGradeRepository.setStudentGrade(studentGradeId, mark);
    }

}
