package com.freeuniproject.emisapp.mapper;

import com.freeuniproject.emisapp.domain.Course;
import com.freeuniproject.emisapp.dto.CourseInfoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CourseInfoMapper {


    @Mapping(source = "id", target = "courseId")
    @Mapping(source = "subject.code", target = "subjectCode")
    @Mapping(source = "name", target = "subjectName")
    CourseInfoDTO toDTO(Course course);

}
