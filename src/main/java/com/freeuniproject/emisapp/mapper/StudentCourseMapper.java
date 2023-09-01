package com.freeuniproject.emisapp.mapper;

import com.freeuniproject.emisapp.domain.StudentCourse;
import com.freeuniproject.emisapp.dto.StudentCourseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentCourseMapper {

    @Mapping(source = "studentCourse.student.id", target = "studentId")
    @Mapping(source = "teachers", target = "subject.teachers")
    @Mapping(source = "studentCourse.course.subject.id", target = "subject.id")
    @Mapping(source = "studentCourse.course.subject.name", target = "subject.name")
    @Mapping(source = "studentCourse.course.subject.description", target = "subject.description")
    StudentCourseDTO toDTO(StudentCourse studentCourse, List<String> teachers);

    StudentCourse fromDTO(StudentCourseDTO dto);

}
