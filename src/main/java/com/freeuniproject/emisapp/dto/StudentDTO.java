package com.freeuniproject.emisapp.dto;

import com.freeuniproject.emisapp.domain.*;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
public class StudentDTO {

    private Long id;

    private String firstName;

    private String lastName;

    private Date birthDate;

    private String email;

    private String address;

    private String phoneNumber;

    private StudentStatus status;

    private DegreeLevel degreeLevel;

    private int credits;

    private double gpa;

}
