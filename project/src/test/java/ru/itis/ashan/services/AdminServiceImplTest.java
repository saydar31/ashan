package ru.itis.ashan.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.context.WebApplicationContext;
import ru.itis.ashan.entities.teacher.Teacher;
import ru.itis.ashan.entities.teacher.TeacherDto;
import ru.itis.ashan.entities.user.Role;
import ru.itis.ashan.entities.user.State;
import ru.itis.ashan.entities.user.UserDto;
import ru.itis.ashan.repositories.TeacherRepository;
import ru.itis.ashan.repositories.UserRepository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

@SpringBootTest
public class AdminServiceImplTest {
    private AdminService adminService;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private UserRepository userRepository;

    private Teacher teacher;

    @BeforeEach
    void setUp() {
        adminService = webApplicationContext.getBean(AdminService.class);
        userRepository = webApplicationContext.getBean(UserRepository.class);
        teacher = Teacher.builder()
                .state(State.NOT_CONFIRMED)
                .surname("Surname")
                .name("Name")
                .patronymic("Patronymic")
                .mail("some@gmail.com")
                .role(Role.TEACHER)
                .hashPassword("password")
                .build();
    }


    @Test
    void findAllNotConfirmedTeachers() {
        teacher.setMail("some1@gmail.com");
        userRepository.save(teacher);
        List<TeacherDto> teacherDtoList = adminService.getAllNotConfirmedTeachers();
        System.out.println(teacherDtoList.size());
    }

    @Test
    void confirmNotConfirmedUser() {
        teacher.setMail("some2@gmail.com");
        teacher.setState(State.NOT_CONFIRMED);
        teacher = userRepository.save(teacher);
        assertTrue(adminService.confirmUser(UserDto.castToDto(teacher)));
    }

    @Test
    void confirmConfirmedUser() {
        teacher.setMail("some3@gmail.com");
        teacher.setState(State.CONFIRMED);
        teacher = userRepository.save(teacher);
        assertFalse(adminService.confirmUser(UserDto.castToDto(teacher)));
    }

    @Test
    void refusedNotConfirmedUser() {
        teacher.setMail("some4@gmail.com");
        teacher.setState(State.NOT_CONFIRMED);
        teacher = userRepository.save(teacher);
        assertTrue(adminService.refuseUser(UserDto.castToDto(teacher)));
    }

    @Test
    void refusedConfirmedUser() {
        teacher.setState(State.CONFIRMED);
        teacher = userRepository.save(teacher);
        assertFalse(adminService.refuseUser(UserDto.castToDto(teacher)));
    }

}
