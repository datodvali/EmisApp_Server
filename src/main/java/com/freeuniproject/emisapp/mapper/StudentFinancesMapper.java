package com.freeuniproject.emisapp.mapper;

import com.freeuniproject.emisapp.domain.StudentFinances;
import com.freeuniproject.emisapp.dto.StudentFinancesDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface StudentFinancesMapper {

    @Mapping(source = "student.id", target = "studentId")
    public StudentFinancesDTO toStudentFinancesDTO(StudentFinances finances);

}
