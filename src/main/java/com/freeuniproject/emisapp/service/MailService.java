package com.freeuniproject.emisapp.service;

import org.springframework.mail.javamail.JavaMailSender;

public interface MailService {

    void sendSimpleMail(String to, String subject, String text);

}
