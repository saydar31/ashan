package ru.itis.ashan.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import ru.itis.ashan.configs.TestApplicationConfig;
import ru.itis.ashan.entities.student.Student;
import ru.itis.ashan.entities.teacher.Teacher;
import ru.itis.ashan.entities.teacher.TeacherDto;
import ru.itis.ashan.entities.user.Role;
import ru.itis.ashan.entities.user.State;
import ru.itis.ashan.repositories.TeacherRepository;

import java.util.List;

@SpringBootTest
public class AdminServiceTest {
    private AdminService adminService;

    @BeforeEach
    void setUp(){
        ApplicationContext context = new AnnotationConfigApplicationContext(TestApplicationConfig.class);
        adminService = context.getBean(AdminService.class);
        UserService userService = context.getBean(UserService.class);

        Teacher teacher = Teacher.builder()
                .state(State.NOT_CONFIRMED)
                .surname("Surname")
                .name("Name")
                .patronymic("Patronymic")
                .mail("some@gmail.com")
                .role(Role.TEACHER)
                .hashPassword("password")
                .build();

        Student student = Student.builder()
                .state(State.NOT_CONFIRMED)
                .surname("Surname")
                .name("Name")
                .patronymic("Patronymic")
                .mail("some@gmail.com")
                .role(Role.STUDENT)
                .hashPassword("password")
                .build();

    }


    @Test
    void findAllNotConfirmedStudents() {

    }

    @Test
    void confirmUser(){

    }
}
