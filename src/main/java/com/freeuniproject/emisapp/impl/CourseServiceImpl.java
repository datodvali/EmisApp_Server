package com.freeuniproject.emisapp.impl;

import com.freeuniproject.emisapp.domain.*;
import com.freeuniproject.emisapp.dto.*;
import com.freeuniproject.emisapp.exception.EmisException;
import com.freeuniproject.emisapp.mapper.*;
import com.freeuniproject.emisapp.repository.CourseRepository;
import com.freeuniproject.emisapp.repository.StudentCourseRepository;
import com.freeuniproject.emisapp.repository.SyllabusRepository;
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

    private final SyllabusRepository syllabusRepository;

    private final CourseMapper courseMapper;

    private final CourseInfoMapper courseInfoMapper;

    private final StudentInfoMapper studentInfoMapper;

    private final StudentGradeMapper studentGradeMapper;

    private final SyllabusMapper syllabusMapper;

    public CourseServiceImpl(CourseRepository courseRepository,
                             StudentCourseRepository studentCourseRepository,
                             SyllabusRepository syllabusRepository, CourseMapper courseMapper,
                             CourseInfoMapper courseInfoMapper,
                             StudentInfoMapper studentInfoMapper,
                             StudentGradeMapper studentGradeMapper,
                             SyllabusMapper syllabusMapper) {
        this.courseRepository = courseRepository;
        this.studentCourseRepository = studentCourseRepository;
        this.syllabusRepository = syllabusRepository;
        this.courseMapper = courseMapper;
        this.courseInfoMapper = courseInfoMapper;
        this.studentInfoMapper = studentInfoMapper;
        this.studentGradeMapper = studentGradeMapper;
        this.syllabusMapper = syllabusMapper;
    }

    @Override
    public Page<CourseInfoForStudentDTO> filterCoursesForStudent(Long studentId, String subjectName, Pageable pageable) {
        Page<Course> resultPage = courseRepository.filterCourses(subjectName, pageable);
        return resultPage.map(course -> courseInfoForStudent(studentId, course));
    }

    @Override
    public SyllabusDTO getSyllabus(Long courseId) {
        Optional<Syllabus> syllabusOptional =  syllabusRepository.findByCourse_Id(courseId);
        return syllabusOptional.map(syllabusMapper::toDTO).orElse(null);
    }

    @Override
    public CourseDetailsForTeacherDTO getCourseDetailsForTeacher(Long courseId) throws EmisException {
        Optional<Course> courseOptional = courseRepository.findById(courseId);
        CourseDTO course = courseOptional.map(courseMapper::toDTO)
                .orElseThrow(() -> new EmisException(String.format("Course with Id %s couldn't be found", courseId)));
        List<StudentCourse> studentCourses = studentCourseRepository.findByCourseId(courseId);
        List<StudentInfoDTO> studentInfos = new ArrayList<>();
        if (studentCourses != null && !studentCourses.isEmpty()) {
            studentCourses.forEach(studentCourse -> studentInfos.add(studentInfoMapper.toDTO(studentCourse.getStudent())));
        }
        CourseDetailsForTeacherDTO courseDetails = new CourseDetailsForTeacherDTO();
        courseDetails.setCourse(course);
        courseDetails.setStudents(studentInfos);
        return courseDetails;
    }

    @Override
    public CourseDetailsForStudentDTO getCourseDetailsForStudent(Long courseId, Long studentId) throws EmisException {
        Optional<Course> courseOptional = courseRepository.findById(courseId);
        CourseDTO course = courseOptional.map(courseMapper::toDTO)
                .orElseThrow(() -> new EmisException(String.format("Course with Id %s couldn't be found", courseId)));
        CourseDetailsForStudentDTO courseDetails = new CourseDetailsForStudentDTO();
        courseDetails.setCourse(course);
        courseDetails.setStudentGradeInfo(getStudentGrades(courseId, studentId));
        return courseDetails;
    }

    private List<StudentGradeDTO> getStudentGrades(Long courseId, Long studentId) throws EmisException {
        Optional<StudentCourse> studentCourseOptional = studentCourseRepository.findByStudentAndCourse(studentId, courseId);
        StudentCourse studentCourse = studentCourseOptional.
                orElseThrow(() -> new EmisException(
                        String.format("Student with id %s doesn't have a course with id %s", studentId, courseId)));
        List<StudentGradeDTO> studentGrades = new ArrayList<>();
        studentCourse.getGradeComponents().
                    forEach(grade -> studentGrades.add(studentGradeMapper.toDTO(grade)));
        return studentGrades;
    }

    private CourseInfoForStudentDTO courseInfoForStudent(Long studentId, Course course) {
        CourseInfoForStudentDTO courseInfo = courseInfoMapper.toCourseInfoForStudentDTO(course);
        courseInfo.setAvailable(getAvailability(studentId, new HashSet<>(course.getSubject().getPrerequisites())));
        return courseInfo;
    }

    private boolean getAvailability(Long studentId, Set<Subject> prerequisites) {
        Set<StudentCourse> studentCourses = new HashSet<>(studentCourseRepository.findPassedCoursesByStudent(studentId));
        Set<Subject> subjects = studentCourses.stream().map(studentCourse -> studentCourse.getCourse().getSubject()).collect(Collectors.toSet());
        return subjects.containsAll(prerequisites);
    }

}
