package com.freeuniproject.emisapp.impl;

import com.freeuniproject.emisapp.domain.StudentSubject;
import com.freeuniproject.emisapp.dto.StudentSubjectDTO;
import com.freeuniproject.emisapp.dto.StudentSubjectCardDTO;
import com.freeuniproject.emisapp.mapper.StudentSubjectMapper;
import com.freeuniproject.emisapp.repository.StudentSubjectRepository;
import com.freeuniproject.emisapp.service.StudentSubjectService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
    public StudentSubjectCardDTO getSubjectCard(Long studentId) {
        List<StudentSubject> studentSubjects = studentSubjectRepository.findAllSubjectsByStudentId(studentId);
        return new StudentSubjectCardDTO(studentId, getSubjectsBySemester(studentSubjects));
    }

    @Override
    public List<StudentSubjectDTO> getStudentsInfoForClass(Long classId) {
//        return studentSubjectRepository.findByClassId(classId);
        return null;
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
