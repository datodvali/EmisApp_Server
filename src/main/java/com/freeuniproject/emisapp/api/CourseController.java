package com.freeuniproject.emisapp.api;

import com.freeuniproject.emisapp.dto.*;
import com.freeuniproject.emisapp.service.CourseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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

    @GetMapping("/filter")
    public Page<CourseInfoDTO> filterCourseInfos(@RequestParam Long studentId, @RequestParam String subjectName,
                                              @RequestParam int page, @RequestParam int size) {
        return courseService.getCourses(studentId, subjectName, PageRequest.of(page, size));
    }

    @GetMapping("/get/course")
    public CourseDTO getCourse(@RequestParam Long id) {
        return courseService.getCourse(id);
    }

    @GetMapping("/detailsForTeacher")
    public CourseDetailsForTeacherDTO getCourseDetailsForTeacher(@RequestParam Long courseId) {
        return courseService.getCourseDetailsForTeacher(courseId);
    }

    @GetMapping("/detailsForStudent")
    public CourseDetailsForStudentDTO getCourseDetailsForStudent(@RequestParam Long courseId, @RequestParam Long studentId) {
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
