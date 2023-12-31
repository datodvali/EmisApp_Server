package com.freeuniproject.emisapp.api;

import com.freeuniproject.emisapp.dto.CourseDTO;
import com.freeuniproject.emisapp.dto.CourseDetailsForStudentDTO;
import com.freeuniproject.emisapp.dto.CourseDetailsForTeacherDTO;
import com.freeuniproject.emisapp.dto.SyllabusDTO;
import com.freeuniproject.emisapp.exception.EmisException;
import com.freeuniproject.emisapp.service.CourseService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emis/api/course")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/detailsForTeacher")
    public CourseDetailsForTeacherDTO getCourseDetailsForTeacher(@RequestParam Long courseId) throws EmisException {
        return courseService.getCourseDetailsForTeacher(courseId);
    }

    @GetMapping("/detailsForStudent")
    public CourseDetailsForStudentDTO getCourseDetailsForStudent(@RequestParam Long courseId, @RequestParam Long studentId) throws EmisException {
        return courseService.getCourseDetailsForStudent(courseId, studentId);
    }

    @GetMapping("/syllabus")
    public ResponseEntity<byte[]> downloadSyllabus(@RequestParam Long courseId) {
        SyllabusDTO syllabus = courseService.getSyllabus(courseId);
        if (syllabus != null) {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentDispositionFormData("attachment", syllabus.getCourseName());
            headers.setContentType(MediaType.APPLICATION_PDF);
            return new ResponseEntity<>(syllabus.getContent(), headers, HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }

}
