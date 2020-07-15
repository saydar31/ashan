package ru.itis.ashan.services;

import ru.itis.ashan.entities.teacher.TeacherDto;
import java.util.List;

public interface TeacherService {

    List<TeacherDto> findConfirmedTeachers();
    TeacherDto getTeacherById(Long id);
    List<TeacherDto> findAll();
}
