package com.freeuniproject.emisapp.impl;

import com.freeuniproject.emisapp.dto.TeacherDTO;
import com.freeuniproject.emisapp.repository.TeacherRepository;
import com.freeuniproject.emisapp.repository.UserRepository;
import com.freeuniproject.emisapp.service.TeacherService;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl implements TeacherService {

    private final UserRepository userRepository;

    private final TeacherRepository teacherRepository;

    public TeacherServiceImpl(UserRepository userRepository, TeacherRepository teacherRepository) {
        this.userRepository = userRepository;
        this.teacherRepository = teacherRepository;
    }

    @Override
    public TeacherDTO getTeacherByEmail(String email) {
        return null;
    }
}
