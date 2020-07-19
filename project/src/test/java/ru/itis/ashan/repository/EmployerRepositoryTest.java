package ru.itis.ashan.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.itis.ashan.config.TestApplicationContextConfig;
import ru.itis.ashan.entities.employer.Employer;
import ru.itis.ashan.entities.user.Role;
import ru.itis.ashan.entities.user.State;
import ru.itis.ashan.repositories.EmployerRepository;

import java.util.List;

public class EmployerRepositoryTest {
    private EmployerRepository employerRepository;

    @BeforeEach()
    public void init() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(TestApplicationContextConfig.class);
        employerRepository = applicationContext.getBean(EmployerRepository.class);
    }

    @Test
    public void testFind() {
        Employer employer = Employer.builder()
                .companyName("com")
                .hashPassword("assxs")
                .role(Role.EMPLOYER)
                .state(State.NOT_CONFIRMED)
                .phoneNumber("888")
                .mail("com@com.com")
                .emailIsConfirmed(true)
                .build();
        employerRepository.save(employer);
        List<Employer> employers = employerRepository.findAllNotConfirmed();
        assert employers.size()>0;
    }
}
