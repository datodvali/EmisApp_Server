package com.freeuniproject.emisapp.repository;

import com.freeuniproject.emisapp.domain.GradeComponent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GradeComponentRepository extends JpaRepository<GradeComponent, Long> {

    List<GradeComponent> findByCourse_Id(Long courseId);

}
