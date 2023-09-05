package com.freeuniproject.emisapp.api;

import com.freeuniproject.emisapp.domain.StudentStatus;
import com.freeuniproject.emisapp.dto.*;
import com.freeuniproject.emisapp.exception.EmisException;
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
    public StudentDTO getStudent(@RequestParam Long studentId) throws EmisException {
        return studentService.getStudent(studentId);
    }

    @PutMapping("/status")
    public void updateStatus(@RequestParam Long studentId, @RequestParam StudentStatus status) {
        studentService.updateStatus(studentId, status);
    }

    @GetMapping("/finances")
    public StudentFinancesDTO getStudentFinances(@RequestParam Long studentId) throws EmisException {
        return studentFinancesService.getStudentFinancesByStudentId(studentId);
    }

    @GetMapping("/courses")
    public List<List<StudentCourseDTO>> getStudentCourses(@RequestParam Long studentId) throws EmisException {
        return studentCourseService.getStudentCourses(studentId);
    }

    @GetMapping("/course/grades")
    public List<StudentGradeDTO> getStudentGradeInfo(@RequestParam Long studentId, @RequestParam Long courseId) {
        return studentCourseService.getStudentGradeInfo(studentId, courseId);
    }

    @PutMapping("/update/mark")
    public boolean updateStudentMark(@RequestParam Long studentGradeId, @RequestParam Double mark) {
        studentGradeService.updateStudentMark(studentGradeId, mark);
        return true;
    }

}
