package com.freeuniproject.emisapp.api;

import com.freeuniproject.emisapp.dto.CourseInfoForStudentDTO;
import com.freeuniproject.emisapp.service.CourseService;
import com.freeuniproject.emisapp.service.StudentCourseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emis/api/courseRegistration")
public class CourseRegistrationController {

    private final StudentCourseService studentCourseService;

    private final CourseService courseService;

    public CourseRegistrationController(StudentCourseService studentCourseService, CourseService courseService) {
        this.studentCourseService = studentCourseService;
        this.courseService = courseService;
    }

    @GetMapping("/filterCourses")
    public Page<CourseInfoForStudentDTO> filterCoursesForRegistration(@RequestParam Long studentId, @RequestParam String subjectName,
                                                           @RequestParam int page, @RequestParam int size) {
        return courseService.filterCoursesForStudent(studentId, subjectName, PageRequest.of(page, size));
    }

    @GetMapping("/registeredCourses")
    public List<CourseInfoForStudentDTO> getRegisteredCourses(@RequestParam Long studentId) {
        return studentCourseService.getRegisteredCoursesForStudent(studentId);
    }

    @PostMapping("/register")
    public void registerCourse(@RequestParam Long studentId, @RequestParam Long courseId) {
        studentCourseService.registerStudentForCourse(studentId, courseId);
    }

}
