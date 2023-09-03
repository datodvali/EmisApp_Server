package com.freeuniproject.emisapp.api;

import com.freeuniproject.emisapp.domain.StudentStatus;
import com.freeuniproject.emisapp.dto.*;
import com.freeuniproject.emisapp.service.StudentFinancesService;
import com.freeuniproject.emisapp.service.StudentGradeService;
import com.freeuniproject.emisapp.service.StudentService;
import com.freeuniproject.emisapp.service.StudentCourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emis/api/student")
public class StudentController {

    private final StudentService studentService;

    private final StudentFinancesService studentFinancesService;

    private final StudentCourseService studentCourseService;

    private final StudentGradeService studentGradeService;

    public StudentController(StudentService studentService, StudentFinancesService studentFinancesService, StudentCourseService studentCourseService, StudentGradeService studentGradeService) {
        this.studentService = studentService;
        this.studentFinancesService = studentFinancesService;
        this.studentCourseService = studentCourseService;
        this.studentGradeService = studentGradeService;
    }

    @GetMapping
    public StudentDTO getStudent(@RequestParam Long id) {
        return studentService.getStudent(id);
    }

    @PutMapping("/update/status")
    public void updateStatus(@RequestParam Long id, @RequestParam StudentStatus status) {
        studentService.updateStatus(id, status);
    }

    @GetMapping("/finances")
    public StudentFinancesDTO getStudentFinances(@RequestParam Long studentId) {
        return studentFinancesService.getStudentFinancesByStudentId(studentId);
    }

    @GetMapping("/courses")
    public List<List<StudentCourseDTO>> getStudentCourses(@RequestParam Long studentId) {
        return studentCourseService.getStudentCourses(studentId);
    }

    @GetMapping("/course/grades")
    public List<StudentGradeDTO> getStudentGradeInfo(@RequestParam Long studentId, @RequestParam Long courseId) {
        return studentCourseService.getStudentGradeInfo(studentId, courseId);
    }

    @PutMapping("/update/mark")
    public void updateStudentMark(@RequestParam Long studentGradeId, @RequestParam Double mark) {
        studentGradeService.updateStudentMark(studentGradeId, mark);
    }

    @GetMapping("/registeredCourses")
    public List<CourseInfoForStudentDTO> getRegisteredCourses(@RequestParam Long studentId) {
        return studentCourseService.getRegisteredCoursesForStudent(studentId);
    }

    @PostMapping("/registerCourse")
    public void registerCourse(@RequestParam Long studentId, @RequestParam Long courseId) {
        studentCourseService.registerStudentForCourse(studentId, courseId);
    }

}
