package ru.itis.ashan.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.itis.ashan.entities.employer.Employer;
import ru.itis.ashan.entities.employer.EmployerDto;
import ru.itis.ashan.exceptions.UserNotFoundException;
import ru.itis.ashan.repositories.EmployerRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmployerServiceTest {
    @Autowired
    private EmployerService employerService;

    @MockBean
    private EmployerRepository employerRepository;

    @BeforeEach
    void setUp() {
        Employer employer = Employer.builder()
                .mail("employer@ashan.ru")
                .hashPassword("password")
                .emailIsConfirmed(true)
                .phoneNumber("8")
                .companyName("company")
                .build();
        Mockito.when(employerRepository.findById(1L)).thenReturn(Optional.of(employer));
    }

    @Test
    void getById() {
        Employer employer = Employer.builder()
                .mail("employer@ashan.ru")
                .hashPassword("password")
                .emailIsConfirmed(true)
                .phoneNumber("8")
                .companyName("company")
                .build();
        EmployerDto employerDto = EmployerDto.castToDto(employer);
        assertEquals(employerDto,employerService.getById(1L));
    }

    @Test
    void edit() {
    }
}