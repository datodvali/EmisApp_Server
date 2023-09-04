package com.freeuniproject.emisapp.service;

import com.freeuniproject.emisapp.dto.StudentFinancesDTO;
import com.freeuniproject.emisapp.exception.EmisException;

public interface StudentFinancesService {

    StudentFinancesDTO getStudentFinancesByStudentId(Long studentId) throws EmisException;

}
