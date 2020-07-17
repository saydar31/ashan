package ru.itis.ashan.services;

import org.springframework.security.core.Authentication;
import ru.itis.ashan.entities.admin.AdminDto;
import ru.itis.ashan.entities.employer.EmployerDto;
import ru.itis.ashan.entities.student.StudentDto;
import ru.itis.ashan.entities.teacher.TeacherDto;
import ru.itis.ashan.entities.user.UserModel;

public interface AuthenticationService {
    StudentDto getStudent(Authentication authentication);
    AdminDto getAdmin(Authentication authentication);
    EmployerDto getEmployer(Authentication authentication);
    UserModel getUserModel(Authentication authentication);
    TeacherDto getTeacher(Authentication authentication);
}
