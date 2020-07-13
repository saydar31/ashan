package ru.itis.ashan.controller.mvc;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.ashan.entities.employer.Employer;
import ru.itis.ashan.entities.employer.EmployerDto;
import ru.itis.ashan.entities.user.UserModel;
import ru.itis.ashan.security.details.UserDetailsImpl;

@Controller
public class EmployerHomePageController {
    @GetMapping("/employer/home")
    @PreAuthorize("hasAuthority('EMPLOYER')")
    public ModelAndView getEmployerHomePage(@AuthenticationPrincipal UserDetailsImpl userDetails){
        UserModel userModel = userDetails.getUserModel();
        Employer employer = (Employer) userModel;
        ModelAndView modelAndView = new ModelAndView("employer_page");
        modelAndView.addObject("employer", EmployerDto.castToDto(employer));
        return modelAndView;
    }
}
