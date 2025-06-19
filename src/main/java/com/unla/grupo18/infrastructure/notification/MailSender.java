package com.unla.grupo18.infrastructure.notification;

import com.unla.grupo18.infrastructure.notification.abstraction.IMailSender;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;

@Service("MailSenderCustom")
public class MailSender implements IMailSender {
    private final JavaMailSender mailSender;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final String MAIL_FROM = "test@gmail.com";
    private final String ALIAS = "Notification Service";

    public MailSender(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public void send(String to, String subject, String message) throws MessagingException, UnsupportedEncodingException {
        MimeMessage simpleMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(simpleMessage, true);

        helper.setFrom(MAIL_FROM, ALIAS);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(message);
        mailSender.send(simpleMessage);
        logger.info("|JavaMailSender| Mail enviado exitosamente");
    }

}
