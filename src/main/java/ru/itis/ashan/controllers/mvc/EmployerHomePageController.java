package ru.itis.ashan.controllers.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itis.ashan.entities.employer.EmployerDto;
import ru.itis.ashan.services.AuthenticationService;

@Controller
public class EmployerHomePageController {
    @Autowired
    private AuthenticationService authenticationService;


    @GetMapping("/employer/home")
    @PreAuthorize("hasAuthority('EMPLOYER')")
    public String getEmployerHomePage(Authentication authentication, Model model) {
        EmployerDto employer = authenticationService.getEmployer(authentication);
        model.addAttribute("employer", employer);
        return "employer_profile";
    }
}
