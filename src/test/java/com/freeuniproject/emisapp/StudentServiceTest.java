package com.freeuniproject.emisapp;

import com.freeuniproject.emisapp.domain.DegreeLevel;
import com.freeuniproject.emisapp.domain.Student;
import com.freeuniproject.emisapp.domain.StudentStatus;
import com.freeuniproject.emisapp.domain.User;
import com.freeuniproject.emisapp.dto.StudentDTO;
import com.freeuniproject.emisapp.exception.EmisException;
import com.freeuniproject.emisapp.repository.StudentRepository;
import com.freeuniproject.emisapp.repository.UserRepository;
import com.freeuniproject.emisapp.service.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class StudentServiceTest {

    @Autowired
    private StudentService studentService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private StudentRepository studentRepository;

    @BeforeEach
    public void initUserStudent() {
        User user = new User();
        user.setFirstName("Test");
        user.setLastName("User");
        user.setBirthDate(new Date());
        user.setAddress("some Address");
        user.setEmail("Test.User@gmail.com");
        user.setPassword("somepass");
        user.setPhoneNumber("599000001");

        Student student = new Student();
        student.setCredits(240);
        student.setCreditsPassed(240);
        student.setDegreeLevel(DegreeLevel.BACHELOR);
        student.setSemester(8);
        student.setGpa(3.6);
        student.setYearEnrolled(2019);
        student.setSubjects(new ArrayList<>());

        student.setUser(user);
        user.setStudent(student);

        userRepository.save(user);
        studentRepository.save(student);
    }

    @Test
    public void testFindStudent() throws EmisException {
        StudentDTO student = studentService.getStudent(1L);
        assertEquals("Test", student.getFirstName());
    }

    @Test
    public void testUpdateStatus() throws EmisException {
        studentService.updateStatus(1L, StudentStatus.GRADUATE);
        StudentDTO student = studentService.getStudent(1L);
        assertNotNull(student);
        assertEquals(student.getStatus(), StudentStatus.GRADUATE);
    }
}
