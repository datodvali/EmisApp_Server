package com.freeuniproject.emisapp.api;

import com.freeuniproject.emisapp.dto.RegistrationformDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emis/api/registration")
public class RegistrationController {

    @PostMapping("/register")
    public void handleRegistration(@RequestBody RegistrationformDTO registrationForm) {
    }

}
