package com.freeuniproject.emisapp.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class RegistrationformDTO {

    private String email;

    private String firstName;

    private String lastName;

    private String password;

    private String birthDate;

    private String phoneNumber;

}
