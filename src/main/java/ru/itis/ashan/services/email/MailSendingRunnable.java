package ru.itis.ashan.services.email;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.internet.MimeMessage;

@AllArgsConstructor
@Slf4j
public class MailSendingRunnable implements Runnable {

    private final Mail mail;

    private final JavaMailSender javaMailSender;

    @Override
    public void run() {
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, "utf-8");
            mimeMessageHelper.setFrom(mail.getFromEmail());
            mimeMessageHelper.setTo(mail.getToEmail());
            mimeMessageHelper.setSubject(mail.getSubject());
            mimeMessageHelper.setText(mail.getContent(),true);
            javaMailSender.send(mimeMessage);
        } catch (Exception exception) {
            log.error(exception.getMessage());
        }
    }
}
