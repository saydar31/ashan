package ru.itis.ashan.services;

import ru.itis.ashan.entities.teacher.Teacher;

public interface CompetenceConfirmationService {
    void confirm(Long id, Teacher teacher);
    void refuse(Long id, Teacher teacher);
}
