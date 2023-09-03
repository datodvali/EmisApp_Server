package com.freeuniproject.emisapp.mapper;

import com.freeuniproject.emisapp.domain.Course;
import com.freeuniproject.emisapp.domain.Subject;
import com.freeuniproject.emisapp.dto.CourseInfoDTO;
import com.freeuniproject.emisapp.dto.CourseInfoForStudentDTO;
import com.freeuniproject.emisapp.dto.CourseInfoForTeacherDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface CourseInfoMapper {

    @Mapping(source = "id", target = "courseId")
    @Mapping(source = "subject.code", target = "subjectCode")
    @Mapping(source = "subject.name", target = "subjectName")
    @Mapping(source = "subject.prerequisites", target = "prerequisites", qualifiedByName = "prerequisiteMapper")
    CourseInfoDTO toDTO(Course course);

    @Mapping(source = "id", target = "courseId")
    @Mapping(source = "subject.code", target = "subjectCode")
    @Mapping(source = "subject.name", target = "subjectName")
    @Mapping(source = "subject.prerequisites", target = "prerequisites", qualifiedByName = "prerequisiteMapper")
    CourseInfoForStudentDTO toCourseInfoForStudentDTO(Course course);

    @Mapping(source = "id", target = "courseId")
    @Mapping(source = "subject.code", target = "subjectCode")
    @Mapping(source = "subject.name", target = "subjectName")
    @Mapping(source = "subject.prerequisites", target = "prerequisites", qualifiedByName = "prerequisiteMapper")
    CourseInfoForTeacherDTO toCourseInfoForTeacherDTO(Course course);

    @Named("prerequisiteMapper")
    default List<String> toPrerequisiteNames(List<Subject> subjects) {
        return subjects.stream().map(Subject::getName).collect(Collectors.toList());
    }

}
