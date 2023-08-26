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

}