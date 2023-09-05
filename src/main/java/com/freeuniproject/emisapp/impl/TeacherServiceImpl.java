package com.freeuniproject.emisapp.impl;

import com.freeuniproject.emisapp.domain.DashboardComponent;
import com.freeuniproject.emisapp.domain.TeacherStatus;
import com.freeuniproject.emisapp.dto.TeacherDTO;
import com.freeuniproject.emisapp.exception.EmisException;
import com.freeuniproject.emisapp.mapper.TeacherMapper;
import com.freeuniproject.emisapp.repository.TeacherRepository;
import com.freeuniproject.emisapp.repository.UserRepository;
import com.freeuniproject.emisapp.service.TeacherService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    private final UserRepository userRepository;

    private final TeacherRepository teacherRepository;

    private final TeacherMapper teacherMapper;

    public TeacherServiceImpl(UserRepository userRepository, TeacherRepository teacherRepository, TeacherMapper teacherMapper) {
        this.userRepository = userRepository;
        this.teacherRepository = teacherRepository;
        this.teacherMapper = teacherMapper;
    }

    @Override
    public TeacherDTO getTeacher(Long teacherId) throws EmisException {
        return teacherRepository.findById(teacherId).map(teacherMapper::toDTO)
                .orElseThrow(() -> new EmisException(String.format("Couldn't find a teacher with id %s", teacherId)));
    }


    @Override
    public List<DashboardComponent> getViewablePages(Long id) {
        // TODO actual implementation
        return List.of(
                DashboardComponent.SUBJECT_CARD_FOR_TEACHER,
                DashboardComponent.LIBRARY
        );
    }

    @Override
    public void updateStatus(Long id, TeacherStatus status) {
        teacherRepository.updateStatus(id, status);
    }

}
