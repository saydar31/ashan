package ru.itis.ashan.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.ashan.entities.student.Student;
import ru.itis.ashan.security.details.UserDetailsImpl;
import ru.itis.ashan.services.StudentService;

@Controller
public class StudentProfileController {

    @Autowired
    public StudentService studentService;

    private Student student;

    @GetMapping("/profile")
    @PreAuthorize("isAuthenticated()")
    public String getProfilePage(Model model) {
        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
        student = (Student) userDetails.getUser();
        model.addAttribute("student", student);
        return "student_profile";
    }

    //редактирование профиля
    @PostMapping("/profile/file")
    public String editProfile(Model model) {
        model.addAttribute("user", student);
        return "student_profile";
    }
}
