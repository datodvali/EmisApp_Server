package com.freeuniproject.emisapp.impl;

import com.freeuniproject.emisapp.domain.StudentCourse;
import com.freeuniproject.emisapp.dto.StudentCourseDTO;
import com.freeuniproject.emisapp.mapper.StudentCourseMapper;
import com.freeuniproject.emisapp.repository.StudentCourseRepository;
import com.freeuniproject.emisapp.service.StudentCourseService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class StudentCourseServiceImpl implements StudentCourseService {

    private final StudentCourseRepository studentCourseRepository;

    private final StudentCourseMapper studentCourseMapper;

    public StudentCourseServiceImpl(StudentCourseRepository studentCourseRepository, StudentCourseMapper studentCourseMapper) {
        this.studentCourseRepository = studentCourseRepository;
        this.studentCourseMapper = studentCourseMapper;
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

    private List<List<StudentCourseDTO>> getCoursesBySemester(List<StudentCourse> studentCourses) {
        List<List<StudentCourseDTO>> subjectsBySemester = new ArrayList<>();

        Map<Integer, List<StudentCourseDTO>> semesterSubjectMap = studentCourses.stream()
                .map(studentCourse -> studentCourseMapper.toDTO(studentCourse, null))
                .collect(Collectors.groupingBy(StudentCourseDTO::getSemester));

        int maxSemester = semesterSubjectMap.keySet().stream().max(Integer::compareTo).orElse(1);
        IntStream.rangeClosed(1, maxSemester)
                .forEach(semester -> subjectsBySemester.add(semesterSubjectMap.get(semester)));

        return subjectsBySemester;
    }

}
