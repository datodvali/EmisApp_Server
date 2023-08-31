package com.freeuniproject.emisapp.repository;

import com.freeuniproject.emisapp.domain.StudentSubject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentSubjectRepository extends JpaRepository<StudentSubject, Long> {

    @Query("SELECT s FROM StudentSubject s WHERE s.student.id = :studentId")
    List<StudentSubject> findAllSubjectsByStudentId(@Param("studentId") Long studentId);

    @Query("SELECT s FROM StudentSubject s WHERE s.course.id = :classId")
    List<StudentSubject> findByClassId(@Param("classId") Long classId);

    @Query("SELECT s FROM StudentSubject s WHERE s.student.id = :studentId AND s.passed = TRUE")
    List<StudentSubject> findPassedSubjectsByStudent(@Param("studentId") Long studentId);
}
