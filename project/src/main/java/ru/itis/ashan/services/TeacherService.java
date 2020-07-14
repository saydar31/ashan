package ru.itis.ashan.services;

import ru.itis.ashan.entities.teacher.TeacherDto;

public interface TeacherService {
    TeacherDto getTeacherById(Long id);
}
