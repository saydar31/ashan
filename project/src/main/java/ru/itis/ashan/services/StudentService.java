package ru.itis.ashan.services;

import ru.itis.ashan.entities.student.Student;
import ru.itis.ashan.entities.student.StudentDto;

import java.util.List;

public interface StudentService {
    Student getStudentById(Long id);
    List<StudentDto> findAll();
}
