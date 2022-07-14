package com.akgarg.springbootemailsender.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * Author: Akhilesh Garg
 * GitHub: <a href="https://github.com/akgarg0472">https://github.com/akgarg0472</a>
 * Date: 14-07-2022
 */
@Service
public class EmailSenderServiceImpl implements EmailSenderService {

    private final JavaMailSender javaMailSender;

    public EmailSenderServiceImpl(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Override
    public void send(String toEmail, String subject, String message) {
        SimpleMailMessage mimeMessage = new SimpleMailMessage();
        mimeMessage.setTo(toEmail);
        mimeMessage.setSubject(subject);
        mimeMessage.setText(message);

        this.javaMailSender.send(mimeMessage);
    }

}
