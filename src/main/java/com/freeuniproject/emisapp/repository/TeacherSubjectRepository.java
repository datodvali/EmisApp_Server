package com.freeuniproject.emisapp.repository;

import com.freeuniproject.emisapp.domain.TeacherCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TeacherSubjectRepository extends JpaRepository<TeacherCourse, Long> {

    @Query("SELECT t FROM TeacherCourse t WHERE t.teacher.id = :teacherId AND t.course.year = :year AND t.course.semester = :semester")
    List<TeacherCourse> findByTeacherYearAndSemester(@Param("teacherId") long teacherId, @Param("year") int year, @Param("semester") int semester);

    List<TeacherCourse> findByTeacherId(long teacherId);

    @Query("SELECT t FROM TeacherCourse t WHERE t.course.finished = FALSE AND t.teacher.id = :teacherId")
    List<TeacherCourse> findUnfinishedCoursesForTeacher(@Param("teacherId") long teacherId);

}
