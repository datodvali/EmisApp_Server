package com.freeuniproject.emisapp.mapper;

import com.freeuniproject.emisapp.domain.Student;
import com.freeuniproject.emisapp.dto.StudentInfoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface StudentInfoMapper {

    @Mappings({
            @Mapping(source = "user.firstName", target = "firstName"),
            @Mapping(source = "user.lastName", target = "lastName"),
            @Mapping(source = "user.email", target = "email")
    })
    StudentInfoDTO toDTO(Student student);

}