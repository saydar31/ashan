package ru.itis.ashan.services;

import ru.itis.ashan.entities.student.Student;
import ru.itis.ashan.entities.student.StudentDto;

import java.util.List;

public interface StudentService {
    StudentDto getStudentById(Long id);
    List<StudentDto> findAll();
}
