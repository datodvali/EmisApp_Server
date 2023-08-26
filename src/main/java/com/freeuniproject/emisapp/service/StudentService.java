package com.freeuniproject.emisapp.service;


import com.freeuniproject.emisapp.dto.StudentDTO;
import com.freeuniproject.emisapp.dto.StudentFinancesDTO;

public interface StudentService {

    public StudentDTO getStudentByEmail(String email);

    public StudentFinancesDTO getStudentFinances(String email);

}
