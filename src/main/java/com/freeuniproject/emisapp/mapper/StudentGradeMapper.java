package com.freeuniproject.emisapp.mapper;

import com.freeuniproject.emisapp.domain.StudentGrade;
import com.freeuniproject.emisapp.dto.StudentGradeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface StudentGradeMapper {

    @Mapping(source = "gradeComponent.name", target = "gradeComponentName")
    @Mapping(source = "gradeComponent.totalPoints", target = "totalPoints")
    @Mapping(source = "mark", target = "currentPoints")
    StudentGradeDTO toDTO(StudentGrade studentGrade);

}
