package ru.itis.ashan.controllers.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
<<<<<<< HEAD
import ru.itis.ashan.entities.signUp.SignUpStudentDto;
=======
>>>>>>> 678de59d103cce8a7a0067fd535e78768ea85834
import ru.itis.ashan.entities.signUp.SignUpTeacherDto;
import ru.itis.ashan.services.SignUpService;

@Controller
public class TeacherSignUpController {

    @Autowired
    private SignUpService signUpService;

    @PreAuthorize("permitAll()")
    @GetMapping("/signUp_teacher")
    public String getPage(Authentication authentication) {
        return "teacher_signUp";
    }

    @PreAuthorize("permitAll()")
    @PostMapping("/signUp_teacher")
    public String signUp(SignUpTeacherDto form) {
        signUpService.signUpTeacher(form);
        return "redirect:/signIn";
    }
}
