package ru.itis.ashan.services.email;

public interface MailSendingRunnableFactory {
    MailSendingRunnable getRunnable(Mail mail);
}
