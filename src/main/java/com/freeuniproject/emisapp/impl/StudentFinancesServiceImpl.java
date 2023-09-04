package com.freeuniproject.emisapp.impl;

import com.freeuniproject.emisapp.dto.StudentFinancesDTO;
import com.freeuniproject.emisapp.exception.EmisException;
import com.freeuniproject.emisapp.mapper.StudentFinancesMapper;
import com.freeuniproject.emisapp.repository.StudentFinancesRepository;
import com.freeuniproject.emisapp.service.StudentFinancesService;
import org.springframework.stereotype.Service;

@Service
public class StudentFinancesServiceImpl implements StudentFinancesService {

    private final StudentFinancesRepository studentFinancesRepository;

    private final StudentFinancesMapper studentFinancesMapper;

    public StudentFinancesServiceImpl(StudentFinancesRepository studentFinancesRepository, StudentFinancesMapper studentFinancesMapper) {
        this.studentFinancesRepository = studentFinancesRepository;
        this.studentFinancesMapper = studentFinancesMapper;
    }

    @Override
    public StudentFinancesDTO getStudentFinancesByStudentId(Long studentId) throws EmisException {
        return studentFinancesRepository.getStudentFinancesByStudentId(studentId)
                .map(studentFinancesMapper::toDTO)
                .orElseThrow(() -> new EmisException(String.format("Couldn't find finance information for student with id %s", studentId)));
    }

}
