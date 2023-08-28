package com.freeuniproject.emisapp.repository;

import com.freeuniproject.emisapp.domain.StudentStatus;
import com.freeuniproject.emisapp.domain.Teacher;
import com.freeuniproject.emisapp.domain.TeacherStatus;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    @Transactional
    @Modifying
    @Query("UPDATE Teacher t SET t.status = :status WHERE t.id = :id")
    void updateStatus(@Param("id") Long id, @Param("status") TeacherStatus status);

}
