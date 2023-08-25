package com.freeuniproject.emisapp.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/emis/api/authentication")
public class AuthenticationController {

    @PostMapping("/login")
    public void handleLogin(@RequestParam String email, @RequestParam String password) {
    }

}
