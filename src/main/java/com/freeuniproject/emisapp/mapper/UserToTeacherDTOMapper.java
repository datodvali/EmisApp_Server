package com.freeuniproject.emisapp.mapper;

import com.freeuniproject.emisapp.domain.User;
import com.freeuniproject.emisapp.dto.TeacherDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserToTeacherDTOMapper {

    public TeacherDTO toTeacherDTO(User user);

}
