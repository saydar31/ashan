package ru.itis.ashan.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.context.WebApplicationContext;
import ru.itis.ashan.entities.student.CompetenceState;
import ru.itis.ashan.entities.student.Student;
import ru.itis.ashan.entities.student.StudentDto;
import ru.itis.ashan.entities.teacher.Teacher;
import ru.itis.ashan.entities.user.Role;
import ru.itis.ashan.entities.user.State;
import ru.itis.ashan.repositories.UserRepository;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TeacherServiceImplTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private TeacherService teacherService;

    private UserRepository userRepository;

    private Teacher teacher = Teacher.builder()
            .state(State.NOT_CONFIRMED)
            .surname("Surname")
            .name("Name")
            .patronymic("Patronymic")
            .mail("some@gmail.com")
            .role(Role.TEACHER)
            .hashPassword("password")
            .build();

    private Student student = Student.builder()
            .state(State.NOT_CONFIRMED)
            .surname("Surname")
            .name("Name")
            .patronymic("Patronymic")
            .mail("some@gmail.com")
            .role(Role.TEACHER)
            .hashPassword("password")
            .groupNumber(808)
            .course(2)
            .competenceState(CompetenceState.NOT_CONFIRMED)
            .build();

    @BeforeEach
    void setUp() {
        teacherService = webApplicationContext.getBean(TeacherService.class);
        userRepository = webApplicationContext.getBean(UserRepository.class);
    }

    @Test
    void getAllTeachers() {
        teacher.setMail("teacher_1@mail.su");
        userRepository.save(teacher);
        System.out.println(teacherService.findAll());
    }

    @Test
    void getAllConfirmedWithNotConfirmedTeachers() {
        teacher.setMail("teacher_2@mail.su");
        userRepository.save(teacher);
        System.out.println(teacherService.findConfirmedTeachers());
    }

    @Test
    void getAllConfirmedWithConfirmedTeachers() {
        teacher.setMail("teacher_3@mail.su");
        teacher.setState(State.CONFIRMED);
        userRepository.save(teacher);
        System.out.println(teacherService.findConfirmedTeachers());
    }

    @Test
    void getTeacherOfStudent() {
        teacher.setMail("teacher_4@mail.su");
        teacher.setState(State.CONFIRMED);

        student.setMail("student_4@mail.su");
        student.setTeacher(teacher);

        userRepository.save(teacher);
        Student student4 = userRepository.save(student);
        System.out.println(teacherService.getTeacherOfStudent(StudentDto.castToDto(student4)));
    }

}
