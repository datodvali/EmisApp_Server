package com.freeuniproject.emisapp.impl;


import com.freeuniproject.emisapp.domain.DegreeLevel;
import com.freeuniproject.emisapp.domain.StudentStatus;
import com.freeuniproject.emisapp.dto.StudentDTO;
import com.freeuniproject.emisapp.dto.StudentFinancesDTO;
import com.freeuniproject.emisapp.mapper.UserToStudentDTOMapper;
import com.freeuniproject.emisapp.repository.StudentRepository;
import com.freeuniproject.emisapp.repository.UserRepository;
import com.freeuniproject.emisapp.service.StudentService;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;

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
    public StudentFinancesDTO getStudentFinances(String email) {
        // TODO implement actual fetching from the repository
        return StudentFinancesDTO.builder()
                .id(1L)
                .studentId(1L)
                .tuitionFee(6500)
                .tuitionFeePaid(3000)
                .scholarship(3500).build();
    }

}
