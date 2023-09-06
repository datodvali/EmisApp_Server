package com.freeuniproject.emisapp.api;

import com.freeuniproject.emisapp.domain.TeacherStatus;
import com.freeuniproject.emisapp.dto.*;
import com.freeuniproject.emisapp.exception.EmisException;
import com.freeuniproject.emisapp.service.CourseService;
import com.freeuniproject.emisapp.service.TeacherService;
import com.freeuniproject.emisapp.service.TeacherCourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emis/api/teacher")
public class TeacherController {

    private final TeacherService teacherService;

    private final TeacherCourseService teacherCourseService;

    private final CourseService courseService;

    public TeacherController(TeacherService teacherService, TeacherCourseService teacherCourseService, CourseService courseService) {
        this.teacherService = teacherService;
        this.teacherCourseService = teacherCourseService;
        this.courseService = courseService;
    }

    @GetMapping
    public TeacherDTO getTeacher(@RequestParam Long teacherId) throws EmisException {
        return teacherService.getTeacher(teacherId);
    }

    @GetMapping("/courses")
    public List<CourseInfoForTeacherDTO> getTeacherCourses(@RequestParam Long teacherId) {
        return teacherCourseService.getTeacherCourses(teacherId);
    }

    @GetMapping("/teachingHistory")
    public List<TeacherCourseDTO> getTeachingHistory(@RequestParam Long teacherId) {
        return teacherCourseService.getTeachingHistory(teacherId);
    }

    @PutMapping("/status")
    public boolean updateStatus(@RequestParam Long teacherId, @RequestParam TeacherStatus status) {
        teacherService.updateStatus(teacherId, status);
        return true;
    }

}
