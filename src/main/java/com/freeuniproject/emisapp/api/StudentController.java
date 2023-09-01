package com.freeuniproject.emisapp.api;

import com.freeuniproject.emisapp.domain.StudentStatus;
import com.freeuniproject.emisapp.dto.StudentCourseDTO;
import com.freeuniproject.emisapp.dto.StudentDTO;
import com.freeuniproject.emisapp.dto.StudentFinancesDTO;
import com.freeuniproject.emisapp.service.StudentFinancesService;
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

    public StudentController(StudentService studentService, StudentFinancesService studentFinancesService, StudentCourseService studentCourseService) {
        this.studentService = studentService;
        this.studentFinancesService = studentFinancesService;
        this.studentCourseService = studentCourseService;
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

    @GetMapping("/subjectCard")
    public List<List<StudentCourseDTO>> getStudentCourses(@RequestParam Long studentId) {
        return studentCourseService.getStudentCourses(studentId);
    }

    @GetMapping("/class")
    public List<StudentCourseDTO> getStudentsInfoForCourse(@RequestParam Long classId) {
        return studentCourseService.getStudentsInfoForCourse(classId);
    }

    @PutMapping("update/student/points")
    public void updateStudentPoints(@RequestParam Long studentGradeId, @RequestParam Double points) {

    }

}
