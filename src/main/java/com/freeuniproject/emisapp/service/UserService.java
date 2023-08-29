package com.freeuniproject.emisapp.service;

import com.freeuniproject.emisapp.domain.UserType;

import java.util.List;

public interface UserService {

    void updatePhoneNumber(Long id, String phoneNumber);

    void updatePassword(Long id, String password);
}
