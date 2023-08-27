package com.freeuniproject.emisapp.api;

import com.freeuniproject.emisapp.domain.StudentStatus;
import com.freeuniproject.emisapp.dto.StudentDTO;
import com.freeuniproject.emisapp.dto.StudentFinancesDTO;
import com.freeuniproject.emisapp.dto.StudentSubjectCardDTO;
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

    @GetMapping
    public StudentDTO getStudent(@RequestParam Long id) {
        return studentService.getStudent(id);
    }

    @PutMapping("/update/status")
    public void updateStatus(@RequestParam Long id, @RequestParam StudentStatus status) {
        studentService.updateStudentStatus(id, status);
    }

    @PutMapping("/update/phoneNumber")
    public void updatePhoneNumber(@RequestParam Long id, @RequestParam String phoneNumber) {
        studentService.updateStudentPhoneNumber(id, phoneNumber);
    }

    @GetMapping("/finances")
    public StudentFinancesDTO getStudentFinances(@RequestParam Long id) {
        return studentFinancesService.getStudentFinancesByStudentId(id);
    }

    @GetMapping("/subjectCard")
    public StudentSubjectCardDTO getStudentSubjectCard(@RequestParam Long id) {
        return studentSubjectService.getSubjectCard(id);
    }

}
