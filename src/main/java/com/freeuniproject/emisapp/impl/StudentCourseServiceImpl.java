package com.freeuniproject.emisapp.impl;

import com.freeuniproject.emisapp.domain.*;
import com.freeuniproject.emisapp.dto.CourseInfoForStudentDTO;
import com.freeuniproject.emisapp.dto.StudentCourseDTO;
import com.freeuniproject.emisapp.dto.StudentGradeDTO;
import com.freeuniproject.emisapp.mapper.CourseInfoMapper;
import com.freeuniproject.emisapp.mapper.StudentCourseMapper;
import com.freeuniproject.emisapp.mapper.StudentGradeMapper;
import com.freeuniproject.emisapp.repository.CourseRepository;
import com.freeuniproject.emisapp.repository.GradeComponentRepository;
import com.freeuniproject.emisapp.repository.StudentCourseRepository;
import com.freeuniproject.emisapp.repository.StudentRepository;
import com.freeuniproject.emisapp.service.StudentCourseService;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class StudentCourseServiceImpl implements StudentCourseService {

    private final StudentCourseRepository studentCourseRepository;

    private final StudentCourseMapper studentCourseMapper;

    private final StudentGradeMapper studentGradeMapper;

    private final StudentRepository studentRepository;

    private final CourseRepository courseRepository;

    private final GradeComponentRepository gradeComponentRepository;

    private final CourseInfoMapper courseInfoMapper;

    public StudentCourseServiceImpl(StudentCourseRepository studentCourseRepository,
                                    StudentCourseMapper studentCourseMapper,
                                    StudentGradeMapper studentGradeMapper,
                                    StudentRepository studentRepository,
                                    CourseRepository courseRepository,
                                    GradeComponentRepository gradeComponentRepository, CourseInfoMapper courseInfoMapper) {
        this.studentCourseRepository = studentCourseRepository;
        this.studentCourseMapper = studentCourseMapper;
        this.studentGradeMapper = studentGradeMapper;
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
        this.gradeComponentRepository = gradeComponentRepository;
        this.courseInfoMapper = courseInfoMapper;
    }

    @Override
    public List<List<StudentCourseDTO>> getStudentCourses(Long studentId) {
        List<StudentCourse> studentCourses = studentCourseRepository.findByStudentId(studentId);
        return getCoursesBySemester(studentCourses);
    }

    @Override
    public List<StudentCourseDTO> getStudentsInfoForCourse(Long courseId) {
//        return studentSubjectRepository.findByClassId(classId);
        return null;
    }

    @Override
    public List<StudentGradeDTO> getStudentGradeInfo(Long studentId, Long courseId) {
        Optional<StudentCourse> optionalStudentCourse = studentCourseRepository.findByStudentAndCourse(studentId, courseId);
        if (optionalStudentCourse.isEmpty()) {
            return null;
        }
        StudentCourse studentCourse = optionalStudentCourse.get();
        return studentCourse.getGradeComponents().stream().map(studentGradeMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public void registerStudentForCourse(Long studentId, Long courseId) {
        Optional<Student> studentOptional = studentRepository.findById(studentId);
        Optional<Course> courseOptional = courseRepository.findById(courseId);
        if (studentOptional.isEmpty() || courseOptional.isEmpty()) {
            return;
        }
        studentCourseRepository.save(
                Objects.requireNonNull(createStudentCourseEntity(studentOptional.get(), courseOptional.get())));
    }

    private StudentCourse createStudentCourseEntity(Student student, Course course) {
        StudentCourse studentCourse = new StudentCourse();
        studentCourse.setStudent(student);
        studentCourse.setCourse(course);
        studentCourse.setGradeComponents(createEmptyStudentGradeComponents(studentCourse));
        studentCourse.setSemester(student.getSemester());
        return studentCourse;
    }

    private List<StudentGrade> createEmptyStudentGradeComponents(StudentCourse studentCourse) {
        List<StudentGrade> studentGrades = new ArrayList<>();
        List<GradeComponent> gradeComponents = gradeComponentRepository.findByCourse_Id(studentCourse.getCourse().getId());
        gradeComponents.forEach(gradeComponent -> {
            StudentGrade studentGrade = new StudentGrade();
            studentGrade.setStudentCourse(studentCourse);
            studentGrade.setGradeComponent(gradeComponent);
        });
        return studentGrades;
    }

    @Override
    public List<CourseInfoForStudentDTO> getRegisteredCoursesForStudent(Long studentId) {
        Optional<Student> studentOptional = studentRepository.findById(studentId);
        if (studentOptional.isEmpty()) {
            return null;
        }
        return studentCourseRepository
                .findByStudentAndSemester(studentId, studentOptional.get().getSemester())
                .stream()
                .map(studentCourse -> courseInfoMapper.toCourseInfoForStudentDTO(studentCourse.getCourse()))
                .collect(Collectors.toList());
    }

    private List<List<StudentCourseDTO>> getCoursesBySemester(List<StudentCourse> studentCourses) {
        List<List<StudentCourseDTO>> subjectsBySemester = new ArrayList<>();

        Map<Integer, List<StudentCourse>> semesterSubjectMap = studentCourses.stream()
                .collect(Collectors.groupingBy(StudentCourse::getSemester));

        int maxSemester = semesterSubjectMap.keySet().stream().max(Integer::compareTo).orElse(1);
        IntStream.rangeClosed(1, maxSemester)
                .forEach(semester -> subjectsBySemester.add(studentCourseMapper.toDTOs(semesterSubjectMap.get(semester))));

        return subjectsBySemester;
    }

}
