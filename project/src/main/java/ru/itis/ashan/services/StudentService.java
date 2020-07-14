package ru.itis.ashan.services;

import ru.itis.ashan.entities.student.Student;
import ru.itis.ashan.entities.student.StudentDto;
import ru.itis.ashan.entities.teacher.Teacher;

import java.util.List;

public interface StudentService {
    Student getStudentById(Long id);

    List<StudentDto> findAll();


    List<StudentDto> getUnconfirmedStudentsByTeacher(Teacher teacher);

}
