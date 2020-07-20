package ru.itis.ashan.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import ru.itis.ashan.entities.employer.Employer;
import ru.itis.ashan.entities.student.Student;
import ru.itis.ashan.services.email.Mail;
import ru.itis.ashan.services.email.MailContentService;
import ru.itis.ashan.services.email.MailSendingService;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class InterviewNotificationServiceImplTest {

    @Autowired
    private InterviewNotificationService notificationService;

    @MockBean
    private MailSendingService mailSendingService;

    @MockBean
    private MailContentService mailContentService;

    @BeforeEach
    void setUp() {
        Employer employer = Employer.builder()
                .emailIsConfirmed(true)
                .mail("saidar31@yandex.ru")
                .build();
        Student student = Student.builder()
                .mail("mail@mail.com")
                .build();
        Mail mail = Mail.builder()
                .fromEmail("ahsan_noreply@mail.ru")
                .toEmail("saidar31@yandex.ru")
                .subject("s")
                .content("<h1>welcome</h1>")
                .build();
        Map<String,Object> body = new HashMap<>();
        body.put("student",student);
        body.put("employer",employer);
        Mockito.when(mailContentService.getContent("welcome_letter.ftlh", body)).thenReturn("<h1>welcome</h1>");
        Mockito.doNothing().when(mailSendingService).send(mail);
    }

    @Test
    void sendInterviewNotification() {
        Employer employer = Employer.builder()
                .emailIsConfirmed(true)
                .mail("saidar31@yandex.ru")
                .build();
        Student student = Student.builder()
                .mail("mail@mail.com")
                .build();
        notificationService.sendInterviewNotification(employer,student);
    }
}