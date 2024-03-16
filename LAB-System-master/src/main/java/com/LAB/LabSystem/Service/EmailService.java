package com.LAB.LabSystem.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


@Service
public class EmailService {
    @Autowired
    private JavaMailSender mailSender;

    public void sendBookingConfirmationEmail(String userEmail, String username,String AppDate ,String datetime, String umail, String clientPhone, String checktype) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(userEmail);
        message.setSubject("Appointment Confirmation");
        message.setText("Dear " + username + ",\n" +
                "This is your Appointment Date: " + AppDate + "\n" +
                "Your Appointment time slot is: " + datetime + "\n" +
                "Your Email is: " + umail + "\n" +
                "Phone Number: " + clientPhone + "\n" +
                "Your CheckingType is: " + checktype);

          mailSender.send(message);
          System.out.println("sending confirmation email successfully");
    }
}