package ru.itis.ashan.services;

import ru.itis.ashan.entities.student.Student;
import ru.itis.ashan.entities.student.StudentDto;

public interface StudentService {
    Student getStudentById(Long id);
    void editStudent(Student student, StudentDto StudentDto);
}
