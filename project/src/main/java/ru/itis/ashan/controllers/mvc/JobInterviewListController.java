package ru.itis.ashan.controllers.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.ashan.entities.employer.Employer;
import ru.itis.ashan.services.AuthenticationService;
import ru.itis.ashan.services.IntervieweeListService;

@Controller
public class JobInterviewListController {
    @Autowired
    private IntervieweeListService intervieweeListService;
    @Autowired
    private AuthenticationService authenticationService;
    @GetMapping("/interviewees")
    @PreAuthorize("hasAuthority('EMPLOYER')")
    public ModelAndView getIntervieweeList(Authentication authentication){
        ModelAndView modelAndView = new ModelAndView("interviewee_list");
        Employer employer = (Employer) authenticationService.getUserModel(authentication);
        modelAndView.addObject("interviewees", intervieweeListService.getInterviewees(employer));
        return modelAndView;
    }
}
