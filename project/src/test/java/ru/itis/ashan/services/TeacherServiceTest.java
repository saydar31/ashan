package ru.itis.ashan.services;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.itis.ashan.entities.teacher.Teacher;
import ru.itis.ashan.entities.teacher.TeacherDto;
import ru.itis.ashan.entities.user.State;
import ru.itis.ashan.repositories.StudentRepository;
import ru.itis.ashan.repositories.TeacherRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherServiceTest {
    @Autowired
    private TeacherService teacherService;

    @MockBean
    private StudentRepository studentRepository;

    @MockBean
    private TeacherRepository teacherRepository;

    @BeforeEach
    public void setUp() {
        Teacher teacher = Teacher.builder()
                .name("Marat")
                .surname("Arslanov")
                .patronymic("Mirzayevich")
                .state(State.CONFIRMED)
                .emailIsConfirmed(true)
                .hashPassword("password")
                .mail("ars@mail.ru")
                .id(1L)
                .build();
        Mockito.when(teacherRepository.findById(1L)).thenReturn(Optional.of(teacher));
        List<Teacher> teachers = new ArrayList<>();
        teachers.add(teacher);
        Mockito.when(teacherRepository.findAllConfirmed()).thenReturn(teachers);
        Mockito.when(teacherRepository.findAll()).thenReturn(teachers);
        Mockito.when(teacherRepository.getOne(1L)).thenReturn(teacher);
        Mockito.when(teacherRepository.save(teacher)).thenReturn(teacher);
    }

    @Test
    void findConfirmedTeachers() {
        List<TeacherDto> teachers = teacherService.findConfirmedTeachers();
        Assert.assertTrue(teachers.size() > 0);
    }

    @Test
    void getTeacherById() {
    }

    @Test
    void editTeacher() {
    }
}