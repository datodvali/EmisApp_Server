package com.freeuniproject.emisapp;

import com.freeuniproject.emisapp.utils.PasswordUtils;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PassTest {

    @Test
    public void test() {
        String salt = PasswordUtils.generateSalt();
        PasswordUtils.verifyPassword(PasswordUtils.hashPassword("password", salt), salt, "password");
    }

}
