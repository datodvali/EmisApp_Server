package com.freeuniproject.emisapp.impl;

import com.freeuniproject.emisapp.dto.CourseInfoForTeacherDTO;
import com.freeuniproject.emisapp.dto.TeacherCourseDTO;
import com.freeuniproject.emisapp.mapper.CourseInfoMapper;
import com.freeuniproject.emisapp.mapper.TeacherCourseMapper;
import com.freeuniproject.emisapp.repository.TeacherCourseRepository;
import com.freeuniproject.emisapp.service.TeacherCourseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeacherCourseServiceImpl implements TeacherCourseService {

    private final TeacherCourseRepository teacherCourseRepository;

    private final TeacherCourseMapper teacherCourseMapper;

    private final CourseInfoMapper courseInfoMapper;

    public TeacherCourseServiceImpl(TeacherCourseRepository teacherCourseRepository, TeacherCourseMapper teacherCourseMapper, CourseInfoMapper courseInfoMapper) {
        this.teacherCourseRepository = teacherCourseRepository;
        this.teacherCourseMapper = teacherCourseMapper;
        this.courseInfoMapper = courseInfoMapper;
    }

    @Override
    public List<CourseInfoForTeacherDTO> getTeacherCourses(Long teacherId) {
        return teacherCourseRepository
                .findUnfinishedCoursesForTeacher(teacherId)
                .stream()
                .map(teacherCourse -> courseInfoMapper.toCourseInfoForTeacherDTO(teacherCourse.getCourse()))
                .collect(Collectors.toList());
    }

    @Override
    public List<TeacherCourseDTO> getTeachingHistory(Long id) {
        return teacherCourseRepository.findByTeacherId(id).stream()
                .map(teacherCourseMapper::toDTO).collect(Collectors.toList());
    }

}
