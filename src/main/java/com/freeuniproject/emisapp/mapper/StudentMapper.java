package com.freeuniproject.emisapp.mapper;

import com.freeuniproject.emisapp.domain.Student;
import com.freeuniproject.emisapp.dto.StudentDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    @Mappings({
            @Mapping(source = "user.firstName", target = "firstName"),
            @Mapping(source = "user.lastName", target = "lastName"),
            @Mapping(source = "user.birthDate", target = "birthDate"),
            @Mapping(source = "user.email", target = "email"),
            @Mapping(source = "user.phoneNumber", target = "phoneNumber"),
            @Mapping(source = "user.address", target = "address")
    })
    StudentDTO toDTO(Student student);

}
