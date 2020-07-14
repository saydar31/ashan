package ru.itis.ashan.controllers.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.ashan.entities.signUp.SignUpEmployerDto;
import ru.itis.ashan.entities.signUp.SignUpStudentDto;
import ru.itis.ashan.entities.signUp.SignUpTeacherDto;
import ru.itis.ashan.services.SignUpService;

@Controller
public class SignUpController {

    @Autowired
    private SignUpService signUpService;

    @PreAuthorize("permitAll()")
    @GetMapping("/signUp")
    public String getPage() {
        return "signUp";
    }

    @PreAuthorize("permitAll()")
    @PostMapping("/signUp_employer")
    public String signUp(SignUpEmployerDto form) {
        signUpService.signUpEmployer(form);
        return "redirect:/signIn";
    }

    @PreAuthorize("permitAll()")
    @PostMapping("/signUp_student")
    public String signUp(SignUpStudentDto signUpDto) {
        signUpService.signUpStudent(signUpDto);
        return "redirect:/signIn";
    }

    @PreAuthorize("permitAll()")
    @PostMapping("/signUp_teacher")
    public String signUp(SignUpTeacherDto form) {
        signUpService.signUpTeacher(form);
        return "redirect:/signIn";
    }
}
