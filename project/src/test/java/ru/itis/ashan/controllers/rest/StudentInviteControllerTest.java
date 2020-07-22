package ru.itis.ashan.controllers.rest;

import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import ru.itis.ashan.entities.employer.Employer;
import ru.itis.ashan.entities.student.Student;
import ru.itis.ashan.entities.user.Role;
import ru.itis.ashan.entities.user.State;
import ru.itis.ashan.repositories.EmployerRepository;
import ru.itis.ashan.repositories.StudentRepository;
import ru.itis.ashan.repositories.UserRepository;
import ru.itis.ashan.security.details.UserDetailsImpl;
import ru.itis.ashan.services.InterviewNotificationService;

import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;


@SpringBootTest
@AutoConfigureMockMvc
class StudentInviteControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentRepository studentRepository;

    @MockBean
    private EmployerRepository employerRepository;

    @MockBean
    private InterviewNotificationService notificationService;

    @MockBean
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @BeforeEach
    void setUp() {
        Student student = Student.builder()
                .mail("student@mail.ru")
                .emailIsConfirmed(true)
                .hashPassword(passwordEncoder.encode("pass"))
                .competence("i am cool")
                .id(1L)
                .role(Role.STUDENT)
                .name("alex")
                .surname("alexyev")
                .invitingEmployers(new HashSet<>())
                .patronymic("alexeyevic")
                .build();
        Employer employer = Employer.builder()
                .companyName("company")
                .phoneNumber("88005553535")
                .id(2L)
                .students(Collections.emptySet())
                .invitedStudents(new HashSet<>())
                .role(Role.EMPLOYER)
                .state(State.CONFIRMED)
                .mail("employer@mail.ru")
                .emailIsConfirmed(true)
                .hashPassword(passwordEncoder.encode("password"))
                .build();
        Mockito.when(studentRepository.findById(ArgumentMatchers.eq(1L))).thenReturn(Optional.of(student));
        Mockito.when(employerRepository.save(employer)).thenReturn(employer);
        Mockito.doNothing().when(notificationService).sendInterviewNotification(employer, student);
        Mockito.when(userRepository.findById(ArgumentMatchers.anyLong())).thenReturn(Optional.of(employer));
    }

    @SneakyThrows
    @Test
    void invite() {
        Employer employer = Employer.builder()
                .companyName("company")
                .phoneNumber("88005553535")
                .id(2L)
                .role(Role.EMPLOYER)
                .state(State.CONFIRMED)
                .mail("employer@mail.ru")
                .invitedStudents(new HashSet<>())
                .students(Collections.emptySet())
                .emailIsConfirmed(true)
                .hashPassword(passwordEncoder.encode("password"))
                .build();
        String TOKEN_ATTR_NAME = "org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository.CSRF_TOKEN";

        HttpSessionCsrfTokenRepository httpSessionCsrfTokenRepository = new HttpSessionCsrfTokenRepository();
        CsrfToken csrfToken = httpSessionCsrfTokenRepository.generateToken(new MockHttpServletRequest());

        mockMvc.perform(post("/student/1/invite").with(user(new UserDetailsImpl(employer))).with(csrf()).sessionAttr(TOKEN_ATTR_NAME, csrfToken).param(csrfToken.getParameterName(), csrfToken.getToken())).andExpect(MockMvcResultMatchers.status().isOk());
    }
}