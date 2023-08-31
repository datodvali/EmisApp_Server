package com.freeuniproject.emisapp.repository;

import com.freeuniproject.emisapp.domain.TeacherSubject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TeacherSubjectRepository extends JpaRepository<TeacherSubject, Long> {

    @Query("SELECT t FROM TeacherSubject t WHERE t.teacher.id = :teacherId" +
            " AND t.course.year = :year AND t.course.semester = :semester")
    List<TeacherSubject> findByTeacherYearAndSemester(@Param("teacherId") long teacherId, @Param("year") int year, @Param("semester") int semester);

    List<TeacherSubject> findByTeacherId(long teacherId);

}
