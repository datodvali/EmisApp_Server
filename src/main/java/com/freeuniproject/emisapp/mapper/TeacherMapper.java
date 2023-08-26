package com.freeuniproject.emisapp.mapper;

import com.freeuniproject.emisapp.domain.Teacher;
import com.freeuniproject.emisapp.dto.TeacherDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TeacherMapper {

    TeacherDTO toDTO(Teacher teacher);

    Teacher fromDTO(TeacherDTO dto);

}
