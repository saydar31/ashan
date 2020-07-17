package ru.itis.ashan.services.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;

@Component
public class MailSendingServiceImpl implements MailSendingService {
    @Autowired
    private MailSendingRunnableFactory mailSendingRunnableFactory;
    @Autowired
    private ExecutorService executorService;

    @Override
    public void send(Mail mail) {
        executorService.execute(mailSendingRunnableFactory.getRunnable(mail));
    }
}
