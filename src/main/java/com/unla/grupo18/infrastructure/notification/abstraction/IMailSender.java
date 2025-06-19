package com.unla.grupo18.infrastructure.notification.abstraction;

import jakarta.mail.MessagingException;

import java.io.UnsupportedEncodingException;

public interface IMailSender {
    void send(String to, String subject, String message) throws MessagingException, UnsupportedEncodingException;
}
