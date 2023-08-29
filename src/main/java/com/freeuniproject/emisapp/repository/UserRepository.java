package com.freeuniproject.emisapp.repository;

import com.freeuniproject.emisapp.domain.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {

    @Transactional
    @Modifying
    @Query("UPDATE User u SET u.phoneNumber = :phoneNumber WHERE u.id = :id")
    void updatePhoneNumber(@Param("id") Long id, @Param("phoneNumber") String phoneNumber);

}
