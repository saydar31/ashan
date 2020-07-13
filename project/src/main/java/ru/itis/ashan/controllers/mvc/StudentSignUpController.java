package ru.itis.ashan.controllers.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.ashan.entities.signUp.SignUpStudentDto;
import ru.itis.ashan.services.SignUpService;

@Controller
public class StudentSignUpController {

    @Autowired
    private SignUpService signUpService;

    @PreAuthorize("permitAll()")
    @GetMapping("/signUp_student")
    public String getPage(Authentication authentication) {
        return "student_signUp";
    }

    @PreAuthorize("permitAll()")
    @PostMapping("/signUp_student")
    public String signUp(SignUpStudentDto signUpDto) {
        signUpService.signUpStudent(signUpDto);
        return "redirect:/signIn";
    }

}