package com.freeuniproject.emisapp.api;

import com.freeuniproject.emisapp.domain.TeacherStatus;
import com.freeuniproject.emisapp.dto.TeacherDTO;
import com.freeuniproject.emisapp.dto.TeacherSubjectCardDTO;
import com.freeuniproject.emisapp.dto.TeacherSubjectDTO;
import com.freeuniproject.emisapp.service.TeacherService;
import com.freeuniproject.emisapp.service.TeacherSubjectService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emis/api/teacher")
public class TeacherController {

    private final TeacherService teacherService;

    private final TeacherSubjectService teacherSubjectService;

    public TeacherController(TeacherService teacherService, TeacherSubjectService teacherSubjectService) {
        this.teacherService = teacherService;
        this.teacherSubjectService = teacherSubjectService;
    }

    @GetMapping
    public TeacherDTO getTeacher(@RequestParam Long id) {
        return teacherService.getTeacher(id);
    }

    @GetMapping("/subjectCard")
    public TeacherSubjectCardDTO getTeacherSubjectCard(@RequestParam Long id) {
        return teacherSubjectService.getSubjectCard(id);
    }

    @GetMapping("/teachingHistory")
    public List<TeacherSubjectDTO> getTeachingHistory(@RequestParam Long id) {
        return teacherSubjectService.getTeachingHistory(id);
    }

    @PutMapping("/update/status")
    public void updateStatus(@RequestParam Long id, @RequestParam TeacherStatus status) {
        teacherService.updateStatus(id, status);
    }

    @PutMapping("/update/phoneNumber")
    public void updatePhoneNumber(@RequestParam Long id, @RequestParam String phoneNumber) {
        teacherService.updatePhoneNumber(id, phoneNumber);
    }

}
