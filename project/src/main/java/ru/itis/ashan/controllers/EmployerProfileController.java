package ru.itis.ashan.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itis.ashan.entities.employer.Employer;
import ru.itis.ashan.security.details.UserDetailsImpl;

@Controller
public class EmployerProfileController {

    @PreAuthorize("hasAuthority('EMPLOYER')")
    @GetMapping("/profile_employer")
    public String getPage(Authentication authentication, Model model){
        UserDetailsImpl userDetail = (UserDetailsImpl) authentication.getPrincipal();
        Employer employer = (Employer) userDetail.getUser();
        model.addAttribute("employer", employer);
        return "employer_profile";
    }
}
