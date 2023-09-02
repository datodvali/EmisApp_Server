package com.freeuniproject.emisapp.mapper;

import com.freeuniproject.emisapp.domain.Syllabus;
import com.freeuniproject.emisapp.dto.SyllabusDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SyllabusMapper {

    @Mapping(source = "course.id", target = "courseId")
    @Mapping(source = "course.subject.name", target = "courseName")
    @Mapping(source = "content", target = "content")
    SyllabusDTO toDTO(Syllabus syllabus);

}
