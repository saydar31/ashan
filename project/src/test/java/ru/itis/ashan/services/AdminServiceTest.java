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
import ru.itis.ashan.repositories.TeacherRepository;
import java.util.List;

@SpringBootTest
public class AdminServiceTest {
    private AdminService adminService;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private TeacherRepository teacherRepository;

    private Teacher teacher = Teacher.builder()
            .state(State.NOT_CONFIRMED)
            .surname("Surname")
            .name("Name")
            .patronymic("Patronymic")
            .mail("some@gmail.com")
            .role(Role.TEACHER)
            .hashPassword("password")
            .build();

    @BeforeEach
    void setUp(){
        adminService = webApplicationContext.getBean(AdminService.class);
        teacherRepository = webApplicationContext.getBean(TeacherRepository.class);
    }


    @Test
    void findAllNotConfirmedStudents() {
        teacherRepository.save(teacher);
        List<TeacherDto> teacherDtoList = adminService.getAllNotConfirmedTeachers();
        System.out.println(teacherDtoList.size());
    }

    @Test
    void confirmUser(){
        teacher = teacherRepository.save(teacher);
        TeacherDto teacherDto = TeacherDto.castToDto(teacher);
        System.out.println(adminService.confirmUser(teacherDto));

        System.out.println(teacherDto.getId() + " " + teacherDto.getState());
    }
}
