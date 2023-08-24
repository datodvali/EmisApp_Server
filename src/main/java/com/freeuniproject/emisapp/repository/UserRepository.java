package com.freeuniproject.emisapp.repository;

import com.freeuniproject.emisapp.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
