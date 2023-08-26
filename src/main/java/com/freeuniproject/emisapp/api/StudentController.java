package com.freeuniproject.emisapp.api;

import com.freeuniproject.emisapp.dto.StudentDTO;
import com.freeuniproject.emisapp.dto.StudentFinancesDTO;
import com.freeuniproject.emisapp.service.StudentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/emis/api/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/{email}")
    public StudentDTO getStudent(@PathVariable String email) {
        return studentService.getStudentByEmail(email);
    }

    @GetMapping("/{email}/finances")
    public StudentFinancesDTO getStudentFinances(@PathVariable String email) {
        return studentService.getStudentFinances(email);
    }

}
