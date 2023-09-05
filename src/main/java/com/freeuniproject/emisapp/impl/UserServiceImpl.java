package com.freeuniproject.emisapp.impl;

import com.freeuniproject.emisapp.exception.EmisException;
import com.freeuniproject.emisapp.repository.StudentRepository;
import com.freeuniproject.emisapp.repository.TeacherRepository;
import com.freeuniproject.emisapp.repository.UserRepository;
import com.freeuniproject.emisapp.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final StudentRepository studentRepository;

    private final TeacherRepository teacherRepository;

    public UserServiceImpl(UserRepository userRepository, StudentRepository studentRepository, TeacherRepository teacherRepository) {
        this.userRepository = userRepository;
        this.studentRepository = studentRepository;
        this.teacherRepository = teacherRepository;
    }

    @Override
    public void updatePhoneNumber(Long id, String phoneNumber) throws EmisException {
        validatePhoneNumber(phoneNumber);
        userRepository.updatePhoneNumber(id, phoneNumber);
    }

    private void validatePhoneNumber(String phoneNumber) throws EmisException {
        if (!phoneNumber.matches("\\d+") || phoneNumber.length() != 9 || phoneNumber.charAt(0) != '5') {
            throw new EmisException(String.format("String passed as a phone number is not in the correct format: %s", phoneNumber));
        }
    }

    @Override
    public void updatePassword(Long id, String password) {
        // TODO implement
    }

}
