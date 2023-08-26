package com.freeuniproject.emisapp.repository;

import com.freeuniproject.emisapp.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u JOIN FETCH u.student WHERE u.email = :email")
    public Optional<User> findStudentUserByEmail(@Param("email") String email);

    @Query("SELECT u FROM User u JOIN FETCH u.teacher WHERE u.email = :email")
    public Optional<User> findTeacherUserByEmail(@Param("email") String email);

    @Modifying
    @Query("UPDATE User u SET u.phoneNumber = :phoneNumber WHERE u.id = :id")
    void updatePhoneNumber(@Param("id") Long id, @Param("phoneNumber") String phoneNumber);
}
