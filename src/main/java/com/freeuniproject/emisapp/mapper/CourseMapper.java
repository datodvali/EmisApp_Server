package com.freeuniproject.emisapp.mapper;

import com.freeuniproject.emisapp.domain.Course;
import com.freeuniproject.emisapp.dto.CourseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CourseMapper {

    @Mappings({
            @Mapping(source = "subject.name", target = "courseName"),
            @Mapping(source = "subject.code", target = "subjectCode"),
            @Mapping(source = "subject.description", target = "subjectDescription"),
    })
    CourseDTO toDTO(Course course);

}
