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
import ru.itis.ashan.entities.teacher.TeacherDto;
import ru.itis.ashan.entities.user.Role;
import ru.itis.ashan.entities.user.State;
import ru.itis.ashan.repositories.UserRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class StudentServiceImplTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private UserRepository userRepository;

    private StudentService studentService;

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
        studentService = webApplicationContext.getBean(StudentService.class);
        userRepository = webApplicationContext.getBean(UserRepository.class);
    }

    @Test
    void getStudentById(){
        student.setMail("23sda3av2x");
        student = userRepository.save(student);

        System.out.println(studentService.getStudentById(student.getId()));
    }

    @Test
    void findAll(){
        student.setMail("23sds_a3sadv2x");
        student = userRepository.save(student);
        System.out.println(studentService.findAll());
    }


    @Test
    void findAllConfirmedCompetence() {
        student.setMail("qweq55cw2e0q");
        teacher.setMail("as59d4asd3a");
        student.setCompetenceState(CompetenceState.CONFIRMED);

        teacher = userRepository.save(teacher);
        student.setTeacher(teacher);
        student = userRepository.save(student);

        System.out.println(studentService.getConfirmedStudentsByTeacher(TeacherDto.castToDto(teacher)));
    }


    @Test
    void findNotConfirmedCompetence() {
        student.setMail("qweqx55cw2edx0q");
        teacher.setMail("ass59d4asd3sa");

        teacher = userRepository.save(teacher);
        student.setTeacher(teacher);
        student = userRepository.save(student);

        System.out.println(studentService.getUnconfirmedStudentsByTeacher(teacher));
    }
}
