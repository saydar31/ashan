package ru.itis.ashan.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.itis.ashan.entities.student.CompetenceState;
import ru.itis.ashan.entities.student.Student;
import ru.itis.ashan.entities.teacher.Teacher;
import ru.itis.ashan.entities.user.Role;
import ru.itis.ashan.entities.user.State;
import ru.itis.ashan.repositories.StudentRepository;
import ru.itis.ashan.repositories.TeacherRepository;

import java.util.HashSet;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CompetenceConfirmationServiceTest {
    @MockBean
    private StudentRepository studentRepository;

    @MockBean
    private TeacherRepository teacherRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private CompetenceConfirmationService competenceConfirmationService;

    private Teacher teacher;
    private Student student;

    @BeforeEach
    void setUp() {
        student = Student.builder()
                .mail("student@ashan.ru")
                .emailIsConfirmed(true)
                .hashPassword(passwordEncoder.encode("1"))
                .role(Role.STUDENT)
                .state(State.CONFIRMED)
                .invitingEmployers(new HashSet<>())
                .name("Aydar")
                .surname("Shaydullin")
                .patronymic("Rashidovich")
                .competenceState(CompetenceState.CONFIRMED)
                .competence("i am cool")
                .course(2)
                .groupNumber(802)
                .tagSet(new HashSet<>())
                .build();
        teacher = Teacher.builder()
                .id(2L)
                .state(State.CONFIRMED)
                .students(new HashSet<>())
                .surname("Surname")
                .name("Name")
                .patronymic("Patronymic")
                .mail("some@gmail.com")
                .role(Role.TEACHER)
                .hashPassword("password")
                .build();
        student.setTeacher(teacher);
        teacher.getStudents().add(student);
        Mockito.when(studentRepository.findById(1L)).thenReturn(Optional.of(student));
        Mockito.when(teacherRepository.save(teacher)).thenReturn(teacher);
    }

    @Test
    void confirm() {
        competenceConfirmationService.confirm(1L, teacher);
    }

    @Test
    void refuse() {
        competenceConfirmationService.refuse(1L, teacher);
    }
}