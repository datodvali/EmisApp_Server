package com.freeuniproject.emisapp.mapper;

import com.freeuniproject.emisapp.domain.Student;
import com.freeuniproject.emisapp.dto.StudentDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    StudentDTO toDTO(Student student);

    Student fromDTO(StudentDTO dto);

}
