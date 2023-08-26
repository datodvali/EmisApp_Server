package com.freeuniproject.emisapp.dto;

import com.freeuniproject.emisapp.domain.UserType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class AuthenticationResponseDTO {

    private boolean successful;

    private UserType userType;

    private long userId;

}
