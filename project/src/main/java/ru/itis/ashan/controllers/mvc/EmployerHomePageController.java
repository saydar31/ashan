package ru.itis.ashan.controllers.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.ashan.entities.employer.Employer;
import ru.itis.ashan.entities.employer.EmployerDto;
import ru.itis.ashan.entities.user.UserModel;
import ru.itis.ashan.security.details.UserDetailsImpl;
import ru.itis.ashan.services.AuthenticationService;

@Controller
public class EmployerHomePageController {
    @Autowired
    private AuthenticationService authenticationService;

    @GetMapping("/employer/home")
    @PreAuthorize("hasAuthority('EMPLOYER')")
    public ModelAndView getEmployerHomePage(Authentication authentication){
        Employer employer = (Employer) authenticationService.getUserModel(authentication);
        ModelAndView modelAndView = new ModelAndView("employer_profile");
        modelAndView.addObject("employer", EmployerDto.castToDto(employer));
        return modelAndView;
    }
}
