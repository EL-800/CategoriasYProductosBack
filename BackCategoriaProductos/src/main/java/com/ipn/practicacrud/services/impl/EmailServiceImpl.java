package com.ipn.practicacrud.services.impl;

import com.ipn.practicacrud.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.task.TaskExecutionProperties;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender mailSender;
    @Override
    public void sendEmail(String to, String subject, String text) {
        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(to);
        email.setSubject(subject);
        email.setText(text);
        mailSender.send(email);
    }
    public void pruebaEmail()
    {
        var email = new SimpleMailMessage();
        email.setTo("pablo_mtzstar@yahoo.com.mx");
        email.setSubject("Prueba");
        email.setText("Esto es una prueba de envio de correos");
        mailSender.send(email);
    }
}
