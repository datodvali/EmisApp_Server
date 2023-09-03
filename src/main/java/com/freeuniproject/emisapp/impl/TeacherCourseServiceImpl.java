package com.freeuniproject.emisapp.impl;

import com.freeuniproject.emisapp.dto.CourseInfoDTO;
import com.freeuniproject.emisapp.dto.CourseInfoForTeacherDTO;
import com.freeuniproject.emisapp.dto.TeacherCourseDTO;
import com.freeuniproject.emisapp.mapper.CourseInfoMapper;
import com.freeuniproject.emisapp.mapper.TeacherCourseMapper;
import com.freeuniproject.emisapp.repository.TeacherSubjectRepository;
import com.freeuniproject.emisapp.service.TeacherCourseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeacherCourseServiceImpl implements TeacherCourseService {

    private final TeacherSubjectRepository teacherSubjectRepository;

    private final TeacherCourseMapper teacherCourseMapper;

    private final CourseInfoMapper courseInfoMapper;

    public TeacherCourseServiceImpl(TeacherSubjectRepository teacherSubjectRepository, TeacherCourseMapper teacherCourseMapper, CourseInfoMapper courseInfoMapper) {
        this.teacherSubjectRepository = teacherSubjectRepository;
        this.teacherCourseMapper = teacherCourseMapper;
        this.courseInfoMapper = courseInfoMapper;
    }

    @Override
    public List<CourseInfoForTeacherDTO> getTeacherCourses(Long teacherId) {
        return teacherSubjectRepository
                .findFinishedCoursesForTeacher(teacherId)
                .stream()
                .map(teacherCourse -> courseInfoMapper.toCourseInfoForTeacherDTO(teacherCourse.getCourse()))
                .collect(Collectors.toList());
    }

    @Override
    public List<TeacherCourseDTO> getTeachingHistory(Long id) {
        return teacherSubjectRepository.findByTeacherId(id).stream()
                .map(teacherCourseMapper::toDTO).collect(Collectors.toList());
    }

}
