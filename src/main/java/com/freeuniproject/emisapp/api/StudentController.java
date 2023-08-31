package com.freeuniproject.emisapp.api;

import com.freeuniproject.emisapp.domain.StudentStatus;
import com.freeuniproject.emisapp.dto.StudentDTO;
import com.freeuniproject.emisapp.dto.StudentFinancesDTO;
import com.freeuniproject.emisapp.dto.StudentSubjectCardDTO;
import com.freeuniproject.emisapp.dto.StudentSubjectDTO;
import com.freeuniproject.emisapp.service.StudentFinancesService;
import com.freeuniproject.emisapp.service.StudentService;
import com.freeuniproject.emisapp.service.StudentSubjectService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

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
        studentService.updateStatus(id, status);
    }

    @GetMapping("/finances")
    public StudentFinancesDTO getStudentFinances(@RequestParam Long id) {
        return studentFinancesService.getStudentFinancesByStudentId(id);
    }

    @GetMapping("/subjectCard")
    public StudentSubjectCardDTO getStudentSubjectCard(@RequestParam Long id) {
        return studentSubjectService.getSubjectCard(id);
    }

    @GetMapping("/class")
    public List<StudentSubjectDTO> getStudentsInfoForClass(@RequestParam Long classId) {
        return studentSubjectService.getStudentsInfoForClass(classId);
    }

    @PutMapping("update/student/points")
    public void updateStudentPoints(@RequestParam Long studentGradeId, @RequestParam Double points) {

    }

}
