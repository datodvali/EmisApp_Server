package com.freeuniproject.emisapp.api;

import com.freeuniproject.emisapp.domain.StudentStatus;
import com.freeuniproject.emisapp.dto.StudentCourseDTO;
import com.freeuniproject.emisapp.dto.StudentDTO;
import com.freeuniproject.emisapp.dto.StudentFinancesDTO;
import com.freeuniproject.emisapp.dto.StudentGradeDTO;
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

    @GetMapping("/studentGradeComponents")
    public List<StudentGradeDTO> getStudentGradeInfo(@RequestParam Long studentCourseId) {
        return studentCourseService.getStudentGradeInfo(studentCourseId);
    }

    @GetMapping("/class")
    public List<StudentCourseDTO> getStudentsInfoForCourse(@RequestParam Long classId) {
        return studentCourseService.getStudentsInfoForCourse(classId);
    }

    @PutMapping("update/student/points")
    public void updateStudentPoints(@RequestParam Long studentGradeId, @RequestParam Double points) {
        studentGradeService.updateStudentPoints(studentGradeId, points);
    }

}
