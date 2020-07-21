package ru.itis.ashan.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.context.WebApplicationContext;
import ru.itis.ashan.entities.student.CompetenceState;
import ru.itis.ashan.entities.student.Student;
import ru.itis.ashan.entities.teacher.Teacher;
import ru.itis.ashan.entities.user.Role;
import ru.itis.ashan.entities.user.State;
import ru.itis.ashan.repositories.StudentRepository;
import ru.itis.ashan.repositories.UserRepository;
import ru.itis.ashan.services.AdminService;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class StudentRepositoryTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private StudentRepository studentRepository;

    private UserRepository userRepository;

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
    void setUp() {
        studentRepository = webApplicationContext.getBean(StudentRepository.class);
        userRepository = webApplicationContext.getBean(UserRepository.class);
    }

    @Test
    void findAllNotConfirmed() {
        student.setMail("adafdas@gasd.sd");
        studentRepository.save(student);
        System.out.println(studentRepository.findAllNotConfirmed());
    }

    @Test
    void findAllNotConfirmedCompetence() {
        student.setMail("qweqcw2eq");
        teacher.setMail("asd4asd3a");

        teacher = userRepository.save(teacher);
        student.setTeacher(teacher);
        student = studentRepository.save(student);

        System.out.println(studentRepository.findAllNotConfirmedCompetenceByTeacher(teacher));
    }

    @Test
    void findAllConfirmedCompetence() {
        student.setMail("qweqcw2e0q");
        teacher.setMail("as9d4asd3a");
        student.setCompetenceState(CompetenceState.CONFIRMED);

        teacher = userRepository.save(teacher);
        student.setTeacher(teacher);
        student = studentRepository.save(student);

        System.out.println(studentRepository.findAllConfirmedCompetenceByTeacher(teacher));
    }

    @Test
    void confirmCompetence() {
        student.setMail("z;doc83cx@dasd.sda");
        student = studentRepository.save(student);
        studentRepository.confirmCompetence(student.getId());
        Optional<Student> optionalStudent = studentRepository.findById(student.getId());
        if (!optionalStudent.isPresent()) {
            System.out.println("fail");
        } else {
            assertEquals(CompetenceState.CONFIRMED, optionalStudent.get().getCompetenceState());
        }
    }

}
