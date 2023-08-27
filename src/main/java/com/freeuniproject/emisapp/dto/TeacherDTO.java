package com.freeuniproject.emisapp.dto;

import com.freeuniproject.emisapp.domain.TeacherPosition;
import com.freeuniproject.emisapp.domain.TeacherStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@NoArgsConstructor
@Setter
@Getter
public class TeacherDTO {

    private Long id;

    private String firstName;

    private String lastName;

    private Date birthDate;

    private String email;

    private String address;

    private String phoneNumber;

    private TeacherPosition position;

    private TeacherStatus status;

}
