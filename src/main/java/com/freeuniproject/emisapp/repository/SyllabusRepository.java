package com.freeuniproject.emisapp.repository;

import com.freeuniproject.emisapp.domain.Syllabus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SyllabusRepository extends JpaRepository<Syllabus, Long> {

    Optional<Syllabus> findByCourse_Id(Long courseId);

}
