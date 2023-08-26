package com.freeuniproject.emisapp.api;

import com.freeuniproject.emisapp.domain.StudentStatus;
import com.freeuniproject.emisapp.dto.StudentDTO;
import com.freeuniproject.emisapp.dto.StudentFinancesDTO;
import com.freeuniproject.emisapp.dto.SubjectCardDTO;
import com.freeuniproject.emisapp.service.StudentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/emis/api/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
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
        return studentService.getStudentFinances(id);
    }

    @GetMapping("/{id}/studentId")
    public SubjectCardDTO getStudentSubjectCard(@PathVariable Long id) {
        return studentService.getStudentSubjectCard(id);
    }

}
