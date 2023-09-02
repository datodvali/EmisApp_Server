package com.freeuniproject.emisapp.impl;

import com.freeuniproject.emisapp.domain.Course;
import com.freeuniproject.emisapp.domain.StudentCourse;
import com.freeuniproject.emisapp.domain.Subject;
import com.freeuniproject.emisapp.dto.CourseDTO;
import com.freeuniproject.emisapp.dto.CourseDetailsDTO;
import com.freeuniproject.emisapp.dto.CourseInfoDTO;
import com.freeuniproject.emisapp.dto.StudentInfoDTO;
import com.freeuniproject.emisapp.mapper.CourseInfoMapper;
import com.freeuniproject.emisapp.mapper.CourseMapper;
import com.freeuniproject.emisapp.mapper.StudentInfoMapper;
import com.freeuniproject.emisapp.repository.CourseRepository;
import com.freeuniproject.emisapp.repository.StudentCourseRepository;
import com.freeuniproject.emisapp.service.CourseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    private final StudentCourseRepository studentCourseRepository;

    private final CourseMapper courseMapper;

    private final CourseInfoMapper courseInfoMapper;

    private final StudentInfoMapper studentInfoMapper;

    public CourseServiceImpl(CourseRepository courseRepository, StudentCourseRepository studentCourseRepository, CourseMapper courseMapper, CourseInfoMapper courseInfoMapper, StudentInfoMapper studentInfoMapper) {
        this.courseRepository = courseRepository;
        this.studentCourseRepository = studentCourseRepository;
        this.courseMapper = courseMapper;
        this.courseInfoMapper = courseInfoMapper;
        this.studentInfoMapper = studentInfoMapper;
    }

    @Override
    public Page<CourseInfoDTO> getCourses(Long studentId, String subjectName, Pageable pageable) {
        Page<Course> resultPage = courseRepository.filterCourses(subjectName, pageable);
        List<CourseInfoDTO> courseInfos = resultPage.stream().map(course -> courseInfoForStudent(studentId, course))
                .collect(Collectors.toList());
        return new PageImpl<>(courseInfos, PageRequest.of(pageable.getPageNumber(), courseInfos.size()), resultPage.getTotalElements());
    }

    @Override
    public CourseDTO getCourse(Long id) {
        return courseRepository.findById(id).map(courseMapper::toDTO).orElse(null);
    }

    @Override
    public CourseDetailsDTO getCourseDetails(Long courseId) {
        Optional<Course> course = courseRepository.findById(courseId);
        List<StudentCourse> studentCourses = studentCourseRepository.findByCourseId(courseId);
        List<StudentInfoDTO> studentInfos = new ArrayList<>();
        if (studentCourses != null && !studentCourses.isEmpty()) {
            studentCourses.forEach(studentCourse -> studentInfoMapper.toDTO(studentCourse.getStudent()));
        }
        return new CourseDetailsDTO(
                course.map(courseMapper::toDTO).orElse(null),
                studentInfos
        );
    }

    private CourseInfoDTO courseInfoForStudent(Long studentId, Course course) {
        CourseInfoDTO courseInfo = courseInfoMapper.toDTO(course);
        courseInfo.setAvailable(getAvailability(studentId, new HashSet<>(course.getSubject().getPrerequisites())));
        return courseInfo;
    }

    private boolean getAvailability(Long studentId, Set<Subject> prerequisites) {
        Set<StudentCourse> studentCourses = new HashSet<>(studentCourseRepository.findPassedCoursesByStudent(studentId));
        Set<Subject> subjects = studentCourses.stream().map(studentCourse -> studentCourse.getCourse().getSubject()).collect(Collectors.toSet());
        return subjects.containsAll(prerequisites);
    }

}
