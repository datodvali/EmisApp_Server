package com.freeuniproject.emisapp.impl;


import com.freeuniproject.emisapp.domain.DashboardComponent;
import com.freeuniproject.emisapp.domain.StudentStatus;
import com.freeuniproject.emisapp.dto.StudentDTO;
import com.freeuniproject.emisapp.exception.EmisException;
import com.freeuniproject.emisapp.mapper.StudentMapper;
import com.freeuniproject.emisapp.repository.StudentRepository;
import com.freeuniproject.emisapp.repository.UserRepository;
import com.freeuniproject.emisapp.service.MailService;
import com.freeuniproject.emisapp.service.StudentService;
import org.springframework.stereotype.Service;

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
    public StudentDTO getStudent(Long id) throws EmisException {
        return studentRepository.findById(id)
                .map(studentMapper::toDTO)
                .orElseThrow(() -> new EmisException(String.format("Student with id %s couldn't be found", id)));
    }

    @Override
    public void updateStatus(Long id, StudentStatus studentStatus) {
        studentRepository.updateStatus(id, studentStatus);
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