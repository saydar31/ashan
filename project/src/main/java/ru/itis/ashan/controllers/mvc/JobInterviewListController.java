package ru.itis.ashan.controllers.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.ashan.entities.employer.Employer;
import ru.itis.ashan.security.details.UserDetailsImpl;
import ru.itis.ashan.services.IntervieweeListService;

@Controller
public class JobInterviewListController {
    @Autowired
    private IntervieweeListService intervieweeListService;
    @GetMapping("/interviewees")
    @PreAuthorize("hasAuthority('EMPLOYER')")
    public ModelAndView getIntervieweeList(@AuthenticationPrincipal UserDetailsImpl userDetails){
        ModelAndView modelAndView = new ModelAndView("interviewee_list");
        Employer employer = (Employer) userDetails.getUser();
        modelAndView.addObject("interviewees", intervieweeListService.getInterviewees(employer));
        return modelAndView;
    }
}
