package ru.itis.ashan.controllers.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.itis.ashan.entities.student.Student;
import ru.itis.ashan.entities.student.StudentDto;
import ru.itis.ashan.repositories.StudentRepository;
import ru.itis.ashan.repositories.TeacherRepository;
import ru.itis.ashan.security.details.UserDetailsImpl;
import ru.itis.ashan.services.StudentService;

@Controller
public class StudentEditPageController {
    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentRepository studentRepository;

    private Student student;

    @Autowired
    private TeacherRepository teacherRepository;

    @PreAuthorize("hasAuthority('STUDENT')")
    @PostMapping("/student/home/edit")
    public String updateStudent(@AuthenticationPrincipal UserDetailsImpl userDetailsImpl, Model model, StudentDto studentDto){
        Student student = studentRepository.getOne(userDetailsImpl.getUser().getId());
        studentService.editStudent(student, studentDto);
        model.addAttribute("student", student);
        return "editProfileStudent";
    }

    @PreAuthorize("hasAuthority('STUDENT')")
    @GetMapping("/student/home/edit")
    public String getHomePage(Authentication authentication, Model model){
        UserDetailsImpl userDetail = (UserDetailsImpl) authentication.getPrincipal();
        student = (Student) userDetail.getUser();
        model.addAttribute("student", student);
        model.addAttribute("teachers", teacherRepository.findAll());
        return "editProfileStudent";
    }

}