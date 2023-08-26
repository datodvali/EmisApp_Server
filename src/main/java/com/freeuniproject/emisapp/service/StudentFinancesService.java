package com.freeuniproject.emisapp.service;

import com.freeuniproject.emisapp.dto.StudentFinancesDTO;

public interface StudentFinancesService {

    StudentFinancesDTO getStudentFinancesByStudentId(Long studentId);

}
