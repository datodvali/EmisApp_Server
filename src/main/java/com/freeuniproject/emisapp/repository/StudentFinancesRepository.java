package com.freeuniproject.emisapp.repository;

import com.freeuniproject.emisapp.domain.StudentFinances;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentFinancesRepository extends JpaRepository<StudentFinances, Long> {
}
