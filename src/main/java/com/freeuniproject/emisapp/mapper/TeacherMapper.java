package com.freeuniproject.emisapp.mapper;

import com.freeuniproject.emisapp.domain.Teacher;
import com.freeuniproject.emisapp.dto.TeacherDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface TeacherMapper {

    @Mappings({
            @Mapping(source = "user.firstName", target = "firstName"),
            @Mapping(source = "user.lastName", target = "lastName"),
            @Mapping(source = "user.birthDate", target = "birthDate"),
            @Mapping(source = "user.email", target = "email"),
            @Mapping(source = "user.phoneNumber", target = "phoneNumber"),
            @Mapping(source = "user.address", target = "address")
    })
    TeacherDTO toDTO(Teacher teacher);

    @Mappings({
            @Mapping(source = "firstName", target = "user.firstName"),
            @Mapping(source = "lastName", target = "user.lastName"),
            @Mapping(source = "birthDate", target = "user.birthDate"),
            @Mapping(source = "email", target = "user.email"),
            @Mapping(source = "phoneNumber", target = "user.phoneNumber"),
            @Mapping(source = "address", target = "user.address")
    })
    Teacher fromDTO(TeacherDTO dto);

}
