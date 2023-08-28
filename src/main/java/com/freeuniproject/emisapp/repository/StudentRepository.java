package com.freeuniproject.emisapp.repository;

import com.freeuniproject.emisapp.domain.Student;
import com.freeuniproject.emisapp.domain.StudentStatus;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StudentRepository extends JpaRepository<Student, Long> {

    @Transactional
    @Modifying
    @Query("UPDATE Student s SET s.status = :status WHERE s.id = :id")
    void updateStatus(@Param("id") Long id, @Param("status") StudentStatus status);

}
