package ru.itis.ashan.bl.services;

import ru.itis.ashan.entities.employer.Employer;
import ru.itis.ashan.entities.student.Student;
import ru.itis.ashan.entities.teacher.Teacher;

import java.util.List;

public interface AdminService {

    //достать не подтвержденных работодателей, студентов и преподавателей
    List<Employer> getAllNotConfirmedEmployers();
    List<Student> getAllNotConfirmedStudents();
    List<Teacher> getAllNotConfirmedTeachers();

    //подтвердить пользователя

}
