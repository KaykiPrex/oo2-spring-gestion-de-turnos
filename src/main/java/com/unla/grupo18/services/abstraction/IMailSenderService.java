package com.unla.grupo18.services.abstraction;

import com.unla.grupo18.infrastructure.notification.MailSenderTitle;
import jakarta.mail.MessagingException;

import java.io.UnsupportedEncodingException;

public interface IMailSenderService {
    void sendMail(MailSenderTitle mailSenderTitle , String mailTo, String displayName) throws MessagingException, UnsupportedEncodingException;
}
