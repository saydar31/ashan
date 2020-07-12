package ru.itis.ashan.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itis.ashan.entities.student.Student;
import ru.itis.ashan.security.details.UserDetailsImpl;

@Controller
public class StudentProfileController {


    @PreAuthorize("hasAuthority('STUDENT')")
    @GetMapping("/profile_student")
    public String getPage(Authentication authentication, Model model){
        UserDetailsImpl userDetail = (UserDetailsImpl) authentication.getPrincipal();
        Student student = (Student)userDetail.getUser();
        model.addAttribute("student", student);
        return "student_profile";
    }
}
