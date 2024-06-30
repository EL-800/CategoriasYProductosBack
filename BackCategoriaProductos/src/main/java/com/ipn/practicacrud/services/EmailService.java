package com.ipn.practicacrud.services;

public interface EmailService {
    public void sendEmail(String to, String subject, String text);
    public void pruebaEmail();
}
