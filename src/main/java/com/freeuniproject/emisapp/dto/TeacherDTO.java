package com.freeuniproject.emisapp.dto;

import com.freeuniproject.emisapp.domain.TeacherStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class TeacherDTO {

    private Long id;

    private String firstName;

    private String lastName;

    private String birthDate;

    private String email;

    private String address;

    private String phoneNumber;

    private String position;

    private TeacherStatus status;

}
