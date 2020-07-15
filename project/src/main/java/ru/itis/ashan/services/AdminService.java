package ru.itis.ashan.services;

import ru.itis.ashan.entities.employer.Employer;
import ru.itis.ashan.entities.employer.EmployerDto;
import ru.itis.ashan.entities.student.Student;
import ru.itis.ashan.entities.student.StudentDto;
import ru.itis.ashan.entities.teacher.Teacher;
import ru.itis.ashan.entities.teacher.TeacherDto;
import ru.itis.ashan.entities.user.UserDto;

import java.util.List;

public interface AdminService {

    //достать не подтвержденных работодателей, студентов и преподавателей
    List<EmployerDto> getAllNotConfirmedEmployers();
    List<StudentDto> getAllNotConfirmedStudents();
    List<TeacherDto> getAllNotConfirmedTeachers();

    //подтвердить пользователя
    boolean confirmUser(UserDto userDto);

    //отказать пользователю
    boolean refuseUser(UserDto userDto);
}
