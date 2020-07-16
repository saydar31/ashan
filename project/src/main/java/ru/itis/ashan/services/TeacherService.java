package ru.itis.ashan.services;

import ru.itis.ashan.entities.student.Student;
import ru.itis.ashan.entities.student.StudentDto;
import ru.itis.ashan.entities.teacher.Teacher;
import ru.itis.ashan.entities.teacher.TeacherDto;
import ru.itis.ashan.entities.teacher.TeacherEditDto;

import java.util.List;

public interface TeacherService {

    //возвращает студентов с неподвержденными компетенциями у преподователя
    List<StudentDto> findAllNotConfirmedСompetenceByTeacher(TeacherDto teacherDto);

    //возвращает студентов с подвержденными компетенциями у преподователя
    List<StudentDto> findAllConfirmedСompetenceByTeacher(TeacherDto teacherDto);

    //подтверждение компетенции
    boolean confirmCompetence(StudentDto studentDto, TeacherDto teacherDto);

    void editTeacher(Teacher teacher, TeacherEditDto teacherEditDto);

    List<Student> getAllStudentsByTeacher(Teacher teacher);

}
