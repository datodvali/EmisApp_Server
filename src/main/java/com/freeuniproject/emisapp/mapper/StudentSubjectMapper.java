package com.freeuniproject.emisapp.mapper;

import com.freeuniproject.emisapp.domain.StudentSubject;
import com.freeuniproject.emisapp.dto.StudentSubjectDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentSubjectMapper {

    @Mapping(source = "studentSubject.student.id", target = "studentId")
    @Mapping(source = "teachers", target = "subject.teachers")
    @Mapping(source = "studentSubject.course.subject.id", target = "subject.id")
    @Mapping(source = "studentSubject.course.subject.name", target = "subject.name")
    @Mapping(source = "studentSubject.course.subject.description", target = "subject.description")
    StudentSubjectDTO toDTO(StudentSubject studentSubject, List<String> teachers);

    StudentSubject fromDTO(StudentSubjectDTO dto);

}
