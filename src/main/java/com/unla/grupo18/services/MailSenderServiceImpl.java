package com.unla.grupo18.services;

import com.unla.grupo18.infrastructure.notification.MailSenderTitle;
import com.unla.grupo18.infrastructure.notification.abstraction.IMailSender;
import com.unla.grupo18.services.abstraction.IMailSenderService;
import jakarta.mail.MessagingException;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;

@Service
public class MailSenderServiceImpl implements IMailSenderService {
    private final IMailSender mailSender;

    public MailSenderServiceImpl(IMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public void sendMail(MailSenderTitle mailSenderTitle , String mailTo, String displayName) throws MessagingException, UnsupportedEncodingException {
        switch (mailSenderTitle) {
            case CANCEL_APPOINTMENT_MAIL_TO_CLIENT: cancelMailClient (mailTo, displayName);
            case CANCEL_APPOINTMENT_MAIL_TO_PROFESSIONAL: cancelMailProfessional(mailTo, displayName);
        }
    }

    private void cancelMailClient (String mailTo, String displayName) throws MessagingException, UnsupportedEncodingException {
        String to = System.getenv("SENDER_MAIL_TEST"); // ONLY FOR TEST //
        mailSender.send(to,"Turno cancelado","Buen día : El cliente " +displayName+ " ha cancelado el turno");
    }

    private void cancelMailProfessional(String mailTo, String displayName) throws MessagingException, UnsupportedEncodingException {
        String to = System.getenv("SENDER_MAIL_TEST"); // ONLY FOR TEST //
        mailSender.send(to,"Turno cancelado","Buen día : El profesional " +displayName+ " ha cancelado el turno");
    }
}
