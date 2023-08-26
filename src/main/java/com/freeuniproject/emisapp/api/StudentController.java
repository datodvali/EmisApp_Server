package com.freeuniproject.emisapp.api;

import com.freeuniproject.emisapp.domain.StudentStatus;
import com.freeuniproject.emisapp.dto.StudentDTO;
import com.freeuniproject.emisapp.dto.StudentFinancesDTO;
import com.freeuniproject.emisapp.dto.SubjectCardDTO;
import com.freeuniproject.emisapp.service.StudentFinancesService;
import com.freeuniproject.emisapp.service.StudentService;
import com.freeuniproject.emisapp.service.StudentSubjectService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/emis/api/student")
public class StudentController {

    private final StudentService studentService;

    private final StudentFinancesService studentFinancesService;

    private final StudentSubjectService studentSubjectService;

    public StudentController(StudentService studentService, StudentFinancesService studentFinancesService, StudentSubjectService studentSubjectService) {
        this.studentService = studentService;
        this.studentFinancesService = studentFinancesService;
        this.studentSubjectService = studentSubjectService;
    }

    @GetMapping("/{id}")
    public StudentDTO getStudent(@PathVariable Long id) {
        return studentService.getStudent(id);
    }

    @PutMapping("/{id}/update/status/{status}")
    public void updateStatus(@PathVariable Long id, @PathVariable StudentStatus status) {
        studentService.updateStudentStatus(id, status);
    }

    @PutMapping("/{id}/update/phoneNumber/{phoneNumber}")
    public void updatePhoneNumber(@PathVariable Long id, @PathVariable String phoneNumber) {
        studentService.updateStudentPhoneNumber(id, phoneNumber);
    }

    @GetMapping("/{id}/finances")
    public StudentFinancesDTO getStudentFinances(@PathVariable Long id) {
        return studentFinancesService.getStudentFinancesByStudentId(id);
    }

    @GetMapping("/{id}/subjectCard")
    public SubjectCardDTO getStudentSubjectCard(@PathVariable Long id) {
        return studentSubjectService.getStudentSubjectCard(id);
    }

}
