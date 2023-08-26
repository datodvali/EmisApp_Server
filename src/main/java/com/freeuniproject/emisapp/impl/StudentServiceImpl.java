package com.freeuniproject.emisapp.impl;


import com.freeuniproject.emisapp.domain.DegreeLevel;
import com.freeuniproject.emisapp.domain.Grade;
import com.freeuniproject.emisapp.domain.StudentStatus;
import com.freeuniproject.emisapp.dto.*;
import com.freeuniproject.emisapp.mapper.UserToStudentDTOMapper;
import com.freeuniproject.emisapp.repository.StudentRepository;
import com.freeuniproject.emisapp.repository.UserRepository;
import com.freeuniproject.emisapp.service.StudentService;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;

@Service
public class StudentServiceImpl implements StudentService {

    private final UserToStudentDTOMapper userToStudentDTOMapper;

    private final UserRepository userRepository;

    private final StudentRepository studentRepository;

    public StudentServiceImpl(UserToStudentDTOMapper userToStudentDTOMapper, UserRepository userRepository, StudentRepository studentRepository) {
        this.userToStudentDTOMapper = userToStudentDTOMapper;
        this.userRepository = userRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    public StudentDTO getStudent(Long id) {
//        return studentRepository.findById(studentId).
//                .map(userToStudentDTOMapper::toStudentDTO).orElse(null);
        return StudentDTO.builder()
                .firstName("Jackson")
                .lastName("Pollock")
                .email("jackson.pollock@gmail.com")
                .address("US-somewhere")
                .birthDate(Date.valueOf(LocalDate.of(1950, 2, 3)))
                .credits(123)
                .degreeLevel(DegreeLevel.BACHELOR)
                .gpa(4.0)
                .phoneNumber("591902990")
                .status(StudentStatus.ACTIVE)
                .build();
    }

    @Override
    public StudentDTO getStudentByEmail(String email) {
//        return userRepository.findStudentUserByEmail(email)
//                .map(userToStudentDTOMapper::toStudentDTO).orElse(null);
        return StudentDTO.builder()
                .firstName("Jackson")
                .lastName("Pollock")
                .email("jackson.pollock@gmail.com")
                .address("US-somewhere")
                .birthDate(Date.valueOf(LocalDate.of(1950, 2, 3)))
                .credits(123)
                .degreeLevel(DegreeLevel.BACHELOR)
                .gpa(4.0)
                .phoneNumber("591902990")
                .status(StudentStatus.ACTIVE)
                .build();
    }

    @Override
    public void updateStudentStatus(Long id, StudentStatus studentStatus) {
        studentRepository.updateStatus(id, studentStatus);
    }

    @Override
    public void updateStudentPhoneNumber(Long id, String phoneNumber) {
        userRepository.updatePhoneNumber(id, phoneNumber);
    }

    @Override
    public StudentFinancesDTO getStudentFinances(Long id) {
        // TODO implement actual fetching from the repository
        return StudentFinancesDTO.builder()
                .id(1L)
                .studentId(1L)
                .tuitionFee(6500)
                .tuitionFeePaid(3000)
                .scholarship(3500).build();
    }

    @Override
    public SubjectCardDTO getStudentSubjectCard(Long id) {
        // TODO implement the actual fetching from the repository
        SubjectCardDTO subjectCardDTO = new SubjectCardDTO();
        subjectCardDTO.setStudentId(1L);

        StudentSubjectDTO studentSubjectDTO1 = new StudentSubjectDTO();
        studentSubjectDTO1.setId(1L);
        studentSubjectDTO1.setStudentId(1L);
        studentSubjectDTO1.setGrade(Grade.A);
        studentSubjectDTO1.setMarkInSubject(91.2);
        studentSubjectDTO1.setSemester(1);
        studentSubjectDTO1.setSubject(
                new SubjectDTO(1L, "biology", "introductory course in biology",
                        Collections.singletonList("Carl linnaeus"))
        );

        StudentSubjectDTO studentSubjectDTO2 = new StudentSubjectDTO();
        studentSubjectDTO2.setId(2L);
        studentSubjectDTO2.setStudentId(2L);
        studentSubjectDTO2.setGrade(Grade.B);
        studentSubjectDTO2.setMarkInSubject(85.2);
        studentSubjectDTO2.setSemester(2);
        studentSubjectDTO2.setSubject(
                new SubjectDTO(1L, "physics", "introductory course in physics",
                        Collections.singletonList("richard feynman"))
        );

        subjectCardDTO.setSubjectsBySemester(Arrays.asList(
                Collections.singletonList(studentSubjectDTO1),
                Collections.singletonList(studentSubjectDTO2)
        ));
        return subjectCardDTO;
    }

}
