package com.freeuniproject.emisapp.impl;

import com.freeuniproject.emisapp.domain.Grade;
import com.freeuniproject.emisapp.domain.StudentSubject;
import com.freeuniproject.emisapp.dto.StudentSubjectDTO;
import com.freeuniproject.emisapp.dto.SubjectCardDTO;
import com.freeuniproject.emisapp.dto.SubjectDTO;
import com.freeuniproject.emisapp.mapper.StudentSubjectMapper;
import com.freeuniproject.emisapp.repository.StudentSubjectRepository;
import com.freeuniproject.emisapp.service.StudentSubjectService;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class StudentSubjectServiceImpl implements StudentSubjectService {

    private final StudentSubjectRepository studentSubjectRepository;

    private final StudentSubjectMapper studentSubjectMapper;

    public StudentSubjectServiceImpl(StudentSubjectRepository studentSubjectRepository, StudentSubjectMapper studentSubjectMapper) {
        this.studentSubjectRepository = studentSubjectRepository;
        this.studentSubjectMapper = studentSubjectMapper;
    }

    @Override
    public SubjectCardDTO getStudentSubjectCard(Long studentId) {
        List<StudentSubject> studentSubjects = studentSubjectRepository.findAllSubjectsByStudentId(studentId);
        return new SubjectCardDTO(studentId, getSubjectsBySemester(studentSubjects));
//        SubjectCardDTO subjectCardDTO = new SubjectCardDTO();
//        subjectCardDTO.setStudentId(1L);
//
//        StudentSubjectDTO studentSubjectDTO1 = new StudentSubjectDTO();
//        studentSubjectDTO1.setId(1L);
//        studentSubjectDTO1.setStudentId(1L);
//        studentSubjectDTO1.setGrade(Grade.A);
//        studentSubjectDTO1.setMarkInSubject(91.2);
//        studentSubjectDTO1.setSemester(1);
//        studentSubjectDTO1.setSubject(
//                new SubjectDTO(1L, "biology", "introductory course in biology",
//                        Collections.singletonList("Carl linnaeus"))
//        );
//
//        StudentSubjectDTO studentSubjectDTO2 = new StudentSubjectDTO();
//        studentSubjectDTO2.setId(2L);
//        studentSubjectDTO2.setStudentId(2L);
//        studentSubjectDTO2.setGrade(Grade.B);
//        studentSubjectDTO2.setMarkInSubject(85.2);
//        studentSubjectDTO2.setSemester(2);
//        studentSubjectDTO2.setSubject(
//                new SubjectDTO(1L, "physics", "introductory course in physics",
//                        Collections.singletonList("richard feynman"))
//        );
//
//        subjectCardDTO.setSubjectsBySemester(Arrays.asList(
//                Collections.singletonList(studentSubjectDTO1),
//                Collections.singletonList(studentSubjectDTO2)
//        ));
//        return subjectCardDTO;
    }

    private List<List<StudentSubjectDTO>> getSubjectsBySemester(List<StudentSubject> studentSubjects) {
        List<List<StudentSubjectDTO>> subjectsBySemester = new ArrayList<>();

        Map<Integer, List<StudentSubjectDTO>> semesterSubjectMap = studentSubjects.stream()
                .map(studentSubject -> studentSubjectMapper.toDTO(studentSubject, null))
                .collect(Collectors.groupingBy(StudentSubjectDTO::getSemester));

        int maxSemester = semesterSubjectMap.keySet().stream().max(Integer::compareTo).orElse(1);
        IntStream.rangeClosed(1, maxSemester)
                .forEach(semester -> subjectsBySemester.add(semesterSubjectMap.get(semester)));

        return subjectsBySemester;
    }

}
