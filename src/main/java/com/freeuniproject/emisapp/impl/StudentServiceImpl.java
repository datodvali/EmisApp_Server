package com.freeuniproject.emisapp.impl;


import com.freeuniproject.emisapp.domain.DashboardComponent;
import com.freeuniproject.emisapp.domain.DegreeLevel;
import com.freeuniproject.emisapp.domain.StudentStatus;
import com.freeuniproject.emisapp.dto.StudentDTO;
import com.freeuniproject.emisapp.mapper.StudentMapper;
import com.freeuniproject.emisapp.repository.StudentRepository;
import com.freeuniproject.emisapp.repository.UserRepository;
import com.freeuniproject.emisapp.service.MailService;
import com.freeuniproject.emisapp.service.StudentService;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentMapper studentMapper;

    private final UserRepository userRepository;

    private final StudentRepository studentRepository;

    private final MailService mailService;

    public StudentServiceImpl(StudentMapper studentMapper, UserRepository userRepository, StudentRepository studentRepository, MailService mailService) {
        this.studentMapper = studentMapper;
        this.userRepository = userRepository;
        this.studentRepository = studentRepository;
        this.mailService = mailService;
    }

    @Override
    public StudentDTO getStudent(Long id) {
        return studentRepository.findById(id)
                .map(studentMapper::toDTO).orElse(null);
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
    public void updateStatus(Long id, StudentStatus studentStatus) {
        studentRepository.updateStatus(id, studentStatus);
    }

    @Override
    public void updatePhoneNumber(Long id, String phoneNumber) {
        userRepository.updatePhoneNumberByStudentId(id, phoneNumber);
    }

    @Override
    public List<DashboardComponent> getViewablePages(Long id) {
        // TODO actual implementation
        return List.of(
                DashboardComponent.SUBJECT_CARD_FOR_STUDENT,
                DashboardComponent.SUBJECT_REGISTRATION,
                DashboardComponent.LIBRARY
        );
    }

    @Override
    public void updatePassword(Long id, String password) {
        // TODO actual implementation
    }

}