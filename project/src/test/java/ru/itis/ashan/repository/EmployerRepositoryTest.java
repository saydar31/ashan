package ru.itis.ashan.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.itis.ashan.config.TestApplicationContextConfig;
import ru.itis.ashan.repositories.EmployerRepository;

public class EmployerRepositoryTest {
    private EmployerRepository employerRepository;

    @BeforeEach()
    public void init() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(TestApplicationContextConfig.class);
        String[] names = applicationContext.getBeanDefinitionNames();
        employerRepository = applicationContext.getBean(EmployerRepository.class);
    }

    @Test
    public void testFind() {

    }
}
