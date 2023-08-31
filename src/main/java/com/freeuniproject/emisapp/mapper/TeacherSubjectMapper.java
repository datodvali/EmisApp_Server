package com.freeuniproject.emisapp.mapper;

import com.freeuniproject.emisapp.domain.TeacherSubject;
import com.freeuniproject.emisapp.dto.TeacherSubjectDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface TeacherSubjectMapper {

    @Mappings({
            @Mapping(source = "teacherSubject.teacher.id", target = "teacherId"),
            @Mapping(source = "teacherSubject.course.subject.id", target = "subjectId"),
            @Mapping(source = "teacherSubject.course.subject.name", target = "subjectName"),
            @Mapping(source = "teacherSubject.course.subject.code", target = "subjectCode"),
    })
    TeacherSubjectDTO toDTO(TeacherSubject teacherSubject);

}
