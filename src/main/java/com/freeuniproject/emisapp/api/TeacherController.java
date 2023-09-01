package com.freeuniproject.emisapp.api;

import com.freeuniproject.emisapp.domain.TeacherStatus;
import com.freeuniproject.emisapp.dto.*;
import com.freeuniproject.emisapp.service.TeacherService;
import com.freeuniproject.emisapp.service.TeacherCourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emis/api/teacher")
public class TeacherController {

    private final TeacherService teacherService;

    private final TeacherCourseService teacherCourseService;

    public TeacherController(TeacherService teacherService, TeacherCourseService teacherCourseService) {
        this.teacherService = teacherService;
        this.teacherCourseService = teacherCourseService;
    }

    @GetMapping
    public TeacherDTO getTeacher(@RequestParam Long id) {
        return teacherService.getTeacher(id);
    }

    @GetMapping("/courses")
    public List<CourseInfoDTO> getTeacherCourses(@RequestParam Long teacherId) {
        return teacherCourseService.getTeacherCourses(teacherId);
    }

    @GetMapping("/teachingHistory")
    public List<TeacherCourseDTO> getTeachingHistory(@RequestParam Long id) {
        return teacherCourseService.getTeachingHistory(id);
    }

    @PutMapping("/update/status")
    public void updateStatus(@RequestParam Long id, @RequestParam TeacherStatus status) {
        teacherService.updateStatus(id, status);
    }

    @GetMapping("gradeStudent")
    public void gradeStudent(@RequestParam Long studentGradeId, @RequestParam int points) {
        teacherService.gradeStudent(studentGradeId, points);
    }

}
