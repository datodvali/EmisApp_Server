package com.freeuniproject.emisapp.repository;

import com.freeuniproject.emisapp.domain.StudentFinances;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface StudentFinancesRepository extends JpaRepository<StudentFinances, Long> {

    @Query("SELECT f FROM StudentFinances f where f.student.id = :studentId")
    Optional<StudentFinances> getStudentFinancesByStudentId(@Param("studentId") Long studentId);

}
