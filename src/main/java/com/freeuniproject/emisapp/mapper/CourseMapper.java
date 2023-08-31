package com.freeuniproject.emisapp.mapper;

import com.freeuniproject.emisapp.domain.Course;
import com.freeuniproject.emisapp.dto.CourseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CourseMapper {

    CourseDTO toDTO(Course course);

}
