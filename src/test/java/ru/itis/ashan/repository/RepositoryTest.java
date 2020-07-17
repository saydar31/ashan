package ru.itis.ashan.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.context.WebApplicationContext;
import ru.itis.ashan.entities.student.CompetenceState;
import ru.itis.ashan.entities.student.Student;
import ru.itis.ashan.entities.tag.Tag;
import ru.itis.ashan.entities.teacher.Teacher;
import ru.itis.ashan.entities.user.Role;
import ru.itis.ashan.entities.user.State;
import ru.itis.ashan.repositories.StudentRepository;
import ru.itis.ashan.repositories.TagRepository;
import ru.itis.ashan.repositories.TeacherRepository;
import ru.itis.ashan.services.AdminService;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootTest
public class RepositoryTest {


    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private TagRepository tagRepository;

    private Student student = Student.builder()
            .id(1L)
            .state(State.NOT_CONFIRMED)
            .surname("Surname")
            .name("Name")
            .patronymic("Patronymic")
            .mail("some@gmail.com")
            .role(Role.STUDENT)
            .hashPassword("password")
            .competenceState(CompetenceState.NOT_CONFIRMED)
            .competence("test")
            .course(3)
            .groupNumber(802)
            .build();

    @BeforeEach
    void setUp() {
        studentRepository = webApplicationContext.getBean(StudentRepository.class);
        tagRepository = webApplicationContext.getBean(TagRepository.class);
    }

    @Test
    void test1() {
        System.out.println(tagRepository.findStudentWithTagName("spring"));

    }
}
