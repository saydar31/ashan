package ru.itis.ashan.bl.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.itis.ashan.bl.repositories.AdminRepository;
import ru.itis.ashan.bl.repositories.EmployerRepository;
import ru.itis.ashan.bl.repositories.StudentRepository;
import ru.itis.ashan.bl.repositories.TeacherRepository;

@Controller
public class AdminServiceImpl {

    @Autowired
    private EmployerRepository employerRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private TeacherRepository teacherRepository;


}
