package ru.itis.ashan.controllers.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itis.ashan.entities.teacher.TeacherDto;
import ru.itis.ashan.services.AuthenticationService;

@Controller
public class TeacherHomepageController {

    @Autowired
    private AuthenticationService authenticationService;

    @GetMapping("/teacher/home")
    @PreAuthorize("hasAnyAuthority('TEACHER')")
    public String getTeacherHomePage(Authentication authentication, Model model){
        TeacherDto teacher = authenticationService.getTeacher(authentication);
        model.addAttribute("teacher", teacher);
        return "teacher_profile";
    }
}
