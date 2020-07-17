package ru.itis.ashan.services.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class MailSendingRunnableFactoryImpl implements MailSendingRunnableFactory {
    @Autowired
    private JavaMailSender javaMailSender;
    @Override
    public MailSendingRunnable getRunnable(Mail mail) {
        return new MailSendingRunnable(mail,javaMailSender);
    }
}
