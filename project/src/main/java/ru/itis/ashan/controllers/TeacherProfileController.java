package ru.itis.ashan.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itis.ashan.entities.student.Student;
import ru.itis.ashan.entities.teacher.Teacher;
import ru.itis.ashan.security.details.UserDetailsImpl;

@Controller
public class TeacherProfileController {

    @PreAuthorize("hasAuthority('TEACHER')")
    @GetMapping("/profile_teacher")
    public String getPage(Authentication authentication, Model model){
        UserDetailsImpl userDetail = (UserDetailsImpl) authentication.getPrincipal();
        Teacher teacher = (Teacher)userDetail.getUser();
        model.addAttribute("teacher", teacher);
        return "teacher_profile";
    }
}
