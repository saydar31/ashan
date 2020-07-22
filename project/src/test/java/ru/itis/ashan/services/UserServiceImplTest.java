package ru.itis.ashan.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.context.WebApplicationContext;
import ru.itis.ashan.entities.teacher.Teacher;
import ru.itis.ashan.entities.user.Role;
import ru.itis.ashan.entities.user.State;
import ru.itis.ashan.repositories.UserRepository;

@SpringBootTest
public class UserServiceImplTest {


    @Autowired
    private WebApplicationContext webApplicationContext;

    private UserRepository userRepository;
    private UserService userService;

    private Teacher teacher = Teacher.builder()
            .state(State.NOT_CONFIRMED)
            .surname("Surname")
            .name("Name")
            .patronymic("Patronymic")
            .mail("some@aF,S0.com")
            .role(Role.TEACHER)
            .hashPassword("password")
            .build();

    @BeforeEach
    void setUp() {
        userService = webApplicationContext.getBean(UserService.class);
        userRepository = webApplicationContext.getBean(UserRepository.class);

    }

    @Test
    void findById(){
        teacher = userRepository.save(teacher);
        System.out.println(userService.findUserModelById(teacher.getId()));

    }


}
