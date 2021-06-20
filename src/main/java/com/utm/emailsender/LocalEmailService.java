package com.utm.emailsender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class LocalEmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendEmail(MailEntity mailEntity) {

       try {
           SimpleMailMessage message = new SimpleMailMessage();
           message.setTo(mailEntity.getTo());
           message.setSubject(mailEntity.getTitle());
           message.setText(mailEntity.getContent());
           message.setFrom("utm.pr.email.sender@gmail.com");

           javaMailSender.send(message);
       } catch (Exception e) {
           System.out.println(Arrays.toString(e.getStackTrace()));
           throw e;
       }

    }

}
