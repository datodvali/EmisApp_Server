package com.freeuniproject.emisapp.mapper;

import com.freeuniproject.emisapp.domain.StudentCourse;
import com.freeuniproject.emisapp.dto.StudentCourseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentCourseMapper {

    @Mappings({
            @Mapping(source = "student.id", target = "studentId"),
            @Mapping(source = "course.id", target = "courseId"),
            @Mapping(source = "course.subject.name", target = "courseName"),
            @Mapping(source = "course.subject.code", target = "subjectCode"),
            @Mapping(source = "markInSubject", target = "mark"),
            @Mapping(source = "course.subject.description", target = "description")
    })
    StudentCourseDTO toDTO(StudentCourse studentCourse);

    default List<StudentCourseDTO> toDTOs(List<StudentCourse> studentCourses) {
        if (studentCourses == null) {
            return Collections.emptyList();
        }
        List<StudentCourseDTO> dtos = new ArrayList<>();
        studentCourses.forEach(course -> dtos.add(this.toDTO(course)));
        return dtos;
    }

}
