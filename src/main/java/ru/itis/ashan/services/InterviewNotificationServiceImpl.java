package ru.itis.ashan.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.ashan.entities.employer.Employer;
import ru.itis.ashan.entities.student.Student;
import ru.itis.ashan.services.email.Mail;
import ru.itis.ashan.services.email.MailContentService;
import ru.itis.ashan.services.email.MailSendingService;

import java.util.HashMap;
import java.util.Map;

@Component
public class InterviewNotificationServiceImpl implements InterviewNotificationService {
    @Autowired
    private MailContentService mailContentService;
    @Autowired
    private MailSendingService mailSendingService;

    @Override
    public void sendInterviewNotification(Employer employer, Student student) {
        Map<String, Object> model = new HashMap<>();
        model.put("student", student);
        model.put("employer", employer);
        String mailText = mailContentService.getContent("interviewMail.ftlh", model);
        Mail mail = Mail.builder()
                .fromEmail("ahsan_noreply@mail.ru")
                .toEmail(student.getMail())
                .subject("Приглашение на собес")
                .content(mailText)
                .build();
        mailSendingService.send(mail);
    }
}
