package com.freeuniproject.emisapp.impl;

import com.freeuniproject.emisapp.domain.Student;
import com.freeuniproject.emisapp.domain.User;
import com.freeuniproject.emisapp.domain.UserType;
import com.freeuniproject.emisapp.dto.AuthenticationResponseDTO;
import com.freeuniproject.emisapp.exception.EmisException;
import com.freeuniproject.emisapp.repository.StudentRepository;
import com.freeuniproject.emisapp.repository.TeacherRepository;
import com.freeuniproject.emisapp.repository.UserRepository;
import com.freeuniproject.emisapp.service.UserService;
import com.freeuniproject.emisapp.utils.PasswordUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final StudentRepository studentRepository;

    private final TeacherRepository teacherRepository;

    private final BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, StudentRepository studentRepository, TeacherRepository teacherRepository) {
        this.userRepository = userRepository;
        this.studentRepository = studentRepository;
        this.teacherRepository = teacherRepository;
        passwordEncoder = new BCryptPasswordEncoder();
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

    @Override
    public AuthenticationResponseDTO login(String email, String password) throws EmisException {
        Optional<User> userOptional = userRepository.findByEmail(email);
        if (userOptional.isEmpty()) {
            throw new EmisException("Email or password is wrong");
        }
        User user = userOptional.get();
        if (!user.getPassword().equals(PasswordUtils.hashPassword(password, PasswordUtils.generateSalt()))) {
            throw new EmisException("Email or password is wrong");
        }
        AuthenticationResponseDTO authResponse = new AuthenticationResponseDTO();
        authResponse.setUserId(user.getId());
        authResponse.setSuccessful(true);
        if (user.getStudent() != null) {
            authResponse.setUserType(UserType.STUDENT);
            authResponse.setIdByRole(user.getStudent().getId());
        }
        authResponse.setUserType(UserType.TEACHER);
        authResponse.setIdByRole(user.getTeacher().getId());
        return authResponse;
    }

}
