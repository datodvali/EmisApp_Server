package com.freeuniproject.emisapp.mapper;

import com.freeuniproject.emisapp.domain.User;
import com.freeuniproject.emisapp.dto.StudentDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface UserToStudentDTOMapper {

    @Mappings({
        @Mapping(source = "student.status", target = "status"),
        @Mapping(source = "student.degreeLevel", target = "degreeLevel"),
        @Mapping(source = "student.credits", target = "credits"),
        @Mapping(source = "student.gpa", target = "gpa")
    })
    public StudentDTO toStudentDTO(User user);

}
