package com.freeuniproject.emisapp.api;

import com.freeuniproject.emisapp.dto.CourseDTO;
import com.freeuniproject.emisapp.dto.CourseInfoDTO;
import com.freeuniproject.emisapp.service.CourseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/emis/api/courseRegistation")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public Page<CourseInfoDTO> getCourseInfos(@RequestParam Long studentId, @RequestParam String subjectName,
                                              @RequestParam int page, @RequestParam int size) {
        return courseService.getCourses(studentId, subjectName, PageRequest.of(page, size));
    }

    @GetMapping
    public CourseDTO getCourse(@RequestParam Long id) {
        return courseService.getCourse(id);
    }

}
