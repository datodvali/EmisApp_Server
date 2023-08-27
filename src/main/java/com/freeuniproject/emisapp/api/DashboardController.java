package com.freeuniproject.emisapp.api;

import com.freeuniproject.emisapp.domain.DashboardComponent;
import com.freeuniproject.emisapp.domain.UserType;
import com.freeuniproject.emisapp.service.StudentService;
import com.freeuniproject.emisapp.service.TeacherService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/emis/api/dashboard")
public class DashboardController {

    private final StudentService studentService;

    private final TeacherService teacherService;

    public DashboardController(StudentService studentService, TeacherService teacherService) {
        this.studentService = studentService;
        this.teacherService = teacherService;
    }

    @GetMapping("/student/{id}/pages")
    public List<DashboardComponent> getViewablePagesForStudent(@PathVariable Long id) {
        return studentService.getViewablePages(id);
    }

    @GetMapping("/teacher/{id}/pages")
    public List<DashboardComponent> getViewablePagesForTeacher(@PathVariable Long id) {
        return teacherService.getViewablePages(id);
    }

}
