package com.freeuniproject.emisapp.impl;

import com.freeuniproject.emisapp.domain.Course;
import com.freeuniproject.emisapp.domain.StudentCourse;
import com.freeuniproject.emisapp.domain.Subject;
import com.freeuniproject.emisapp.dto.*;
import com.freeuniproject.emisapp.mapper.CourseInfoMapper;
import com.freeuniproject.emisapp.mapper.CourseMapper;
import com.freeuniproject.emisapp.mapper.StudentGradeMapper;
import com.freeuniproject.emisapp.mapper.StudentInfoMapper;
import com.freeuniproject.emisapp.repository.CourseRepository;
import com.freeuniproject.emisapp.repository.StudentCourseRepository;
import com.freeuniproject.emisapp.repository.StudentGradeRepository;
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

    private final StudentGradeRepository studentGradeRepository;

    private final StudentGradeMapper studentGradeMapper;

    public CourseServiceImpl(CourseRepository courseRepository, StudentCourseRepository studentCourseRepository, CourseMapper courseMapper, CourseInfoMapper courseInfoMapper, StudentInfoMapper studentInfoMapper, StudentGradeRepository studentGradeRepository, StudentGradeMapper studentGradeMapper) {
        this.courseRepository = courseRepository;
        this.studentCourseRepository = studentCourseRepository;
        this.courseMapper = courseMapper;
        this.courseInfoMapper = courseInfoMapper;
        this.studentInfoMapper = studentInfoMapper;
        this.studentGradeRepository = studentGradeRepository;
        this.studentGradeMapper = studentGradeMapper;
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
    public CourseDetailsForTeacherDTO getCourseDetailsForTeacher(Long courseId) {
        Optional<Course> course = courseRepository.findById(courseId);
        List<StudentCourse> studentCourses = studentCourseRepository.findByCourseId(courseId);
        List<StudentInfoDTO> studentInfos = new ArrayList<>();
        if (studentCourses != null && !studentCourses.isEmpty()) {
            studentCourses.forEach(studentCourse -> studentInfoMapper.toDTO(studentCourse.getStudent()));
        }
        CourseDTO courseDTO = course.map(courseMapper::toDTO).orElse(null);
        CourseDetailsForTeacherDTO courseDetails = new CourseDetailsForTeacherDTO();
        courseDetails.setCourse(courseDTO);
        courseDetails.setStudents(studentInfos);
        return courseDetails;
    }

    @Override
    public CourseDetailsForStudentDTO getCourseDetailsForStudent(Long courseId, Long studentId) {
        Optional<Course> courseOptional = courseRepository.findById(courseId);
        CourseDTO course = courseOptional.map(courseMapper::toDTO).orElse(null);
        CourseDetailsForStudentDTO courseDetails = new CourseDetailsForStudentDTO();
        courseDetails.setCourse(course);
        courseDetails.setStudentGradeInfo(getStudentGrades(courseId, studentId));
        return courseDetails;
    }

    private List<StudentGradeDTO> getStudentGrades(Long courseId, Long studentId) {
        Optional<StudentCourse> studentCourseOptional = studentCourseRepository.findByStudentAndCourse(studentId, courseId);
        StudentCourse studentCourse = studentCourseOptional.orElse(null);
        List<StudentGradeDTO> studentGrades = new ArrayList<>();
        if (studentCourse != null) {
            studentCourse.getGradeComponents().
                    forEach(grade -> studentGrades.add(studentGradeMapper.toDTO(grade)));
        }
        return studentGrades;
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
