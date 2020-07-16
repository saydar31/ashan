package ru.itis.ashan.services;

import ru.itis.ashan.entities.student.Student;

public interface StudentService {
    Student getStudentById(Long id);
}
