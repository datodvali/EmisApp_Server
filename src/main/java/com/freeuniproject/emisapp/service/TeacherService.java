package com.freeuniproject.emisapp.service;

import com.freeuniproject.emisapp.dto.TeacherDTO;
import org.springframework.stereotype.Service;


public interface TeacherService {

    TeacherDTO getTeacherByEmail(String email);

}
