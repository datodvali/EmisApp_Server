package com.freeuniproject.emisapp;

import com.freeuniproject.emisapp.domain.*;
import com.freeuniproject.emisapp.dto.StudentDTO;
import com.freeuniproject.emisapp.dto.TeacherDTO;
import com.freeuniproject.emisapp.exception.EmisException;
import com.freeuniproject.emisapp.repository.TeacherRepository;
import com.freeuniproject.emisapp.repository.UserRepository;
import com.freeuniproject.emisapp.service.TeacherService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class TeacherServiceTest {

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @BeforeEach
    public void initUser() {
        User user = new User();
        user.setFirstName("Test");
        user.setLastName("User");
        user.setBirthDate(new Date());
        user.setAddress("some Address");
        user.setEmail("Test.User@gmail.com");
        user.setPassword("somepass");
        user.setPhoneNumber("599000001");

        Teacher teacher = new Teacher();
        teacher.setSalary(1000);
        teacher.setStatus(TeacherStatus.ACTIVE);
        teacher.setSubjects(Collections.emptySet());

        teacher.setUser(user);
        user.setTeacher(teacher);

        userRepository.save(user);
        teacherRepository.save(teacher);
    }

    @Test
    public void testFindTeacher() throws EmisException {
        TeacherDTO teacher = teacherService.getTeacher(1L);
        assertEquals("Test", teacher.getFirstName());
    }

    @Test
    public void testUpdateStatus() throws EmisException {
        teacherService.updateStatus(1L, TeacherStatus.NON_ACTIVE);
        TeacherDTO teacher = teacherService.getTeacher(1L);
        assertNotNull(teacher);
        assertEquals(teacher.getStatus(), TeacherStatus.NON_ACTIVE);
    }

}
