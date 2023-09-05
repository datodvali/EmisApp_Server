package com.freeuniproject.emisapp.repository;

import com.freeuniproject.emisapp.domain.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CourseRepository extends JpaRepository<Course, Long> {

    @Query("SELECT c FROM Course c Where LOWER(c.subject.name) like LOWER(CONCAT('%', :subjectName, '%'))")
    Page<Course> filterCourses(@Param("subjectName") String subjectName, Pageable pageable);

}
