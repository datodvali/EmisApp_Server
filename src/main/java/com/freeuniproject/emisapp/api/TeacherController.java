package com.freeuniproject.emisapp.api;

import com.freeuniproject.emisapp.dto.TeacherDTO;
import com.freeuniproject.emisapp.service.TeacherService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emis/api/teacher")
public class TeacherController {

    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping("/get/{email}")
    public TeacherDTO getTeacher(@PathVariable String email) {
        return teacherService.getTeacherByEmail(email);
    }

}
