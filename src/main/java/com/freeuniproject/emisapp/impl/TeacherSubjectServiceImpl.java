package com.freeuniproject.emisapp.impl;

import com.freeuniproject.emisapp.dto.TeacherSubjectCardDTO;
import com.freeuniproject.emisapp.dto.TeacherSubjectDTO;
import com.freeuniproject.emisapp.mapper.TeacherSubjectMapper;
import com.freeuniproject.emisapp.repository.TeacherSubjectRepository;
import com.freeuniproject.emisapp.service.TeacherSubjectService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeacherSubjectServiceImpl implements TeacherSubjectService {

    private final TeacherSubjectRepository teacherSubjectRepository;

    private final TeacherSubjectMapper teacherSubjectMapper;

    public TeacherSubjectServiceImpl(TeacherSubjectRepository teacherSubjectRepository, TeacherSubjectMapper teacherSubjectMapper) {
        this.teacherSubjectRepository = teacherSubjectRepository;
        this.teacherSubjectMapper = teacherSubjectMapper;
    }

    @Override
    public TeacherSubjectCardDTO getSubjectCard(Long id) {
        TeacherSubjectCardDTO subjectCard = new TeacherSubjectCardDTO();
        subjectCard.setTeacherId(id);
        subjectCard.setSubjects(
                teacherSubjectRepository.findByTeacherYearAndSemester(id, 2019, 1)
                    .stream().map(teacherSubjectMapper::toDTO).collect(Collectors.toList())
        );
//        TeacherSubjectDTO teacherSubjectDTO1 = new TeacherSubjectDTO();
//        teacherSubjectDTO1.setSubjectId(1L);
//        teacherSubjectDTO1.setTeacherId(id);
//        teacherSubjectDTO1.setSubjectCode("BIO1");
//        teacherSubjectDTO1.setSubjectName("biology");
//        TeacherSubjectDTO teacherSubjectDTO2 = new TeacherSubjectDTO();
//        teacherSubjectDTO2.setSubjectId(2L);
//        teacherSubjectDTO2.setTeacherId(id);
//        teacherSubjectDTO2.setSubjectCode("CHE1");
//        teacherSubjectDTO2.setSubjectName("chemistry");
//        subjectCard.setSubjects(List.of(teacherSubjectDTO1, teacherSubjectDTO2));
        return subjectCard;
    }

    @Override
    public List<TeacherSubjectDTO> getTeachingHistory(Long id) {
        return teacherSubjectRepository.findByTeacherId(id).stream()
                .map(teacherSubjectMapper::toDTO).collect(Collectors.toList());
//        TeacherSubjectDTO teacherSubjectDTO1 = new TeacherSubjectDTO();
//        teacherSubjectDTO1.setSubjectId(1L);
//        teacherSubjectDTO1.setTeacherId(id);
//        teacherSubjectDTO1.setSubjectCode("BIO1");
//        teacherSubjectDTO1.setSubjectName("biology");
//        TeacherSubjectDTO teacherSubjectDTO2 = new TeacherSubjectDTO();
//        teacherSubjectDTO2.setSubjectId(2L);
//        teacherSubjectDTO2.setTeacherId(id);
//        teacherSubjectDTO2.setSubjectCode("CHE1");
//        teacherSubjectDTO2.setSubjectName("chemistry");
//        return List.of(teacherSubjectDTO1, teacherSubjectDTO2);
    }

}
