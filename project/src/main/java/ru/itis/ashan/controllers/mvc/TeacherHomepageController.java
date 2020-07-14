package ru.itis.ashan.controllers.mvc;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.ashan.entities.teacher.Teacher;
import ru.itis.ashan.entities.teacher.TeacherDto;
import ru.itis.ashan.security.details.UserDetailsImpl;

@Controller
public class TeacherHomepageController {
    @GetMapping("/teacher/home")
    @PreAuthorize("hasAnyAuthority('TEACHER')")
    public ModelAndView getTeacherHomePage(@AuthenticationPrincipal UserDetailsImpl userDetails){
        Teacher teacher = (Teacher) userDetails.getUser();
        ModelAndView modelAndView = new ModelAndView("teacher_profile");
        modelAndView.addObject("teacher", TeacherDto.castToDto(teacher));
        return modelAndView;
    }
}
