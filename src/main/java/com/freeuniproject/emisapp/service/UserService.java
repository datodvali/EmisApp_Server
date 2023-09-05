package com.freeuniproject.emisapp.service;

import com.freeuniproject.emisapp.exception.EmisException;

public interface UserService {

    void updatePhoneNumber(Long id, String phoneNumber) throws EmisException;

    void updatePassword(Long id, String password);
}
