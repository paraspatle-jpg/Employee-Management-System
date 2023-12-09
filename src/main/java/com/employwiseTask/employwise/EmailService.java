package com.employwiseTask.employwise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String fromEmail;

    public void sendNewEmployeeNotification(String managerEmail, String employeeName, String phoneNumber, String email) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(fromEmail);
        message.setTo(managerEmail);
        message.setSubject("New Employee Notification");
        message.setText(String.format(
                "%s will now work under you. Mobile number is %s and email is %s",
                employeeName, phoneNumber, email));

        javaMailSender.send(message);
    }
}
