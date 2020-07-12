package ru.itis.ashan.services;

import ru.itis.ashan.entities.signUp.SignUpEmployerDto;
import ru.itis.ashan.entities.signUp.SignUpStudentDto;
import ru.itis.ashan.entities.signUp.SignUpTeacherDto;

public interface SignUpService {

    void signUpStudent(SignUpStudentDto signUpDto);

    void signUpTeacher(SignUpTeacherDto teacherDto);

    void signUpEmployer(SignUpEmployerDto employerDto);
}
