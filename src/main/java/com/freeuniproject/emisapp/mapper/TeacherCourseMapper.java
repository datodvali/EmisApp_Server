package com.freeuniproject.emisapp.mapper;

import com.freeuniproject.emisapp.domain.TeacherCourse;
import com.freeuniproject.emisapp.dto.TeacherCourseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface TeacherCourseMapper {

    @Mappings({
            @Mapping(source = "teacherCourse.teacher.id", target = "teacherId"),
            @Mapping(source = "teacherCourse.course.subject.id", target = "subjectId"),
            @Mapping(source = "teacherCourse.course.subject.name", target = "subjectName"),
            @Mapping(source = "teacherCourse.course.subject.code", target = "subjectCode"),
    })
    TeacherCourseDTO toDTO(TeacherCourse teacherCourse);

}
