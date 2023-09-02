package com.freeuniproject.emisapp.api;

import com.freeuniproject.emisapp.dto.CourseDTO;
import com.freeuniproject.emisapp.dto.CourseDetailsDTO;
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

    @GetMapping("/details")
    public List<CourseDetailsDTO> getCourseDetails(@RequestParam Long courseId) {
        return courseService.getCourseDetails(courseId);
    }


}
