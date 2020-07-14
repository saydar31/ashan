package ru.itis.ashan.services;

import ru.itis.ashan.entities.student.Student;
import ru.itis.ashan.entities.student.StudentDto;
import ru.itis.ashan.entities.teacher.Teacher;
import ru.itis.ashan.entities.user.UserDto;

import java.util.List;

public interface StudentService {
    Student getStudentById(Long id);

    List<StudentDto> getUnconfirmedStudentsByTeacher(Teacher teacher);
}
