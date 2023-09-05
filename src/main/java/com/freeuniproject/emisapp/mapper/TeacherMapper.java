package com.freeuniproject.emisapp.mapper;

import com.freeuniproject.emisapp.domain.Teacher;
import com.freeuniproject.emisapp.dto.TeacherDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

import java.util.Date;

@Mapper(componentModel = "spring")
public interface TeacherMapper {

    @Mappings({
            @Mapping(source = "user.firstName", target = "firstName"),
            @Mapping(source = "user.lastName", target = "lastName"),
            @Mapping(source = "user.birthDate", target = "birthDate", qualifiedByName = "dateMapper"),
            @Mapping(source = "user.email", target = "email"),
            @Mapping(source = "user.phoneNumber", target = "phoneNumber"),
            @Mapping(source = "user.address", target = "address"),
            @Mapping(source = "position.name", target = "position")
    })
    TeacherDTO toDTO(Teacher teacher);

    @Named("dateMapper")
    default String dateMapper(Date birthDate) {
        return birthDate.toString();
    }

}
