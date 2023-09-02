package com.freeuniproject.emisapp.repository;

import com.freeuniproject.emisapp.domain.StudentGrade;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StudentGradeRepository extends JpaRepository<StudentGrade, Long> {

    @Transactional
    @Modifying
    @Query("UPDATE StudentGrade s SET s.mark = :mark WHERE s.id = :studentGradeId")
    void setStudentGrade(@Param("studentGradeId") long studentGradeId,@Param("mark") double mark);
}
