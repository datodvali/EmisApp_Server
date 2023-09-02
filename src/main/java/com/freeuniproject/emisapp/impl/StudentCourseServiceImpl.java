package com.freeuniproject.emisapp.impl;

import com.freeuniproject.emisapp.domain.StudentCourse;
import com.freeuniproject.emisapp.dto.StudentCourseDTO;
import com.freeuniproject.emisapp.dto.StudentGradeDTO;
import com.freeuniproject.emisapp.mapper.StudentCourseMapper;
import com.freeuniproject.emisapp.mapper.StudentGradeMapper;
import com.freeuniproject.emisapp.repository.StudentCourseRepository;
import com.freeuniproject.emisapp.service.StudentCourseService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class StudentCourseServiceImpl implements StudentCourseService {

    private final StudentCourseRepository studentCourseRepository;

    private final StudentCourseMapper studentCourseMapper;

    private final StudentGradeMapper studentGradeMapper;

    public StudentCourseServiceImpl(StudentCourseRepository studentCourseRepository, StudentCourseMapper studentCourseMapper, StudentGradeMapper studentGradeMapper) {
        this.studentCourseRepository = studentCourseRepository;
        this.studentCourseMapper = studentCourseMapper;
        this.studentGradeMapper = studentGradeMapper;
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
