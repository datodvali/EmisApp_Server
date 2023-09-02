package com.freeuniproject.emisapp.repository;

import com.freeuniproject.emisapp.domain.StudentCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface StudentCourseRepository extends JpaRepository<StudentCourse, Long> {

    @Query("SELECT s FROM StudentCourse s WHERE s.student.id = :studentId")
    List<StudentCourse> findByStudentId(@Param("studentId") Long studentId);

    @Query("SELECT s FROM StudentCourse s WHERE s.course.id = :classId")
    List<StudentCourse> findByCourseId(@Param("classId") Long classId);

    @Query("SELECT s FROM StudentCourse s WHERE s.student.id = :studentId AND s.passed = TRUE")
    List<StudentCourse> findPassedCoursesByStudent(@Param("studentId") Long studentId);

    @Query("SELECT s FROM StudentCourse s WHERE s.student.id = :studentId AND s.course.id = :courseId")
    Optional<StudentCourse> findByStudentAndCourse(@Param("studentId") Long studentId, @Param("courseId") Long courseId);

}
