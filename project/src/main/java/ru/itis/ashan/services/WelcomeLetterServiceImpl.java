package ru.itis.ashan.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.ashan.entities.user.UserModel;
import ru.itis.ashan.services.email.Mail;
import ru.itis.ashan.services.email.MailContentService;
import ru.itis.ashan.services.email.MailSendingService;

import java.util.HashMap;
import java.util.Map;

@Component
public class WelcomeLetterServiceImpl implements WelcomeLetterService {
    @Autowired
    private MailContentService mailContentService;
    @Autowired
    private MailSendingService mailSendingService;
    @Autowired
    private MailConfirmationService mailConfirmationService;
    @Override
    public void sendWelcomeLetter(UserModel userModel) {
        Map<String,Object> body = new HashMap<>();
        body.put("user",userModel);
        String hash = mailConfirmationService.getConfirmationString(userModel);
        body.put("hash",hash);
        String mailHtml = mailContentService.getContent("welcome_letter.ftlh",body);
        Mail mail =Mail.builder()
                .content(mailHtml)
                .subject("welcome")
                .toEmail(userModel.getMail())
                .fromEmail("ahsan_noreply@mail.ru")
                .build();
        mailSendingService.send(mail);
    }
}
