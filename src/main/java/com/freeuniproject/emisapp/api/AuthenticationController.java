package com.freeuniproject.emisapp.api;

import com.freeuniproject.emisapp.dto.AuthenticationResponseDTO;
import com.freeuniproject.emisapp.exception.EmisException;
import com.freeuniproject.emisapp.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/emis/api/authentication")
public class AuthenticationController {

    private final UserService userService;

    public AuthenticationController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public AuthenticationResponseDTO login(@RequestParam String email, @RequestParam String password) throws EmisException {
        return userService.login(email, password);
    }

}
