package ru.itis.ashan.controllers.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.ashan.entities.student.StudentDto;
import ru.itis.ashan.entities.teacher.Teacher;
import ru.itis.ashan.security.details.UserDetailsImpl;
import ru.itis.ashan.services.StudentService;

import java.util.List;

@Controller
public class CompetenceConfirmationPageController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/myStudents/competence/toConfirm")
    @PreAuthorize("hasAuthority('TEACHER')")
    public ModelAndView getCompetencePage(@AuthenticationPrincipal UserDetailsImpl userDetails){
        Teacher teacher = (Teacher) userDetails.getUser();
        List<StudentDto> studentDtoList = studentService.getUnconfirmedStudentsByTeacher(teacher);
        ModelAndView modelAndView = new ModelAndView("studentCompetencesList");
        modelAndView.addObject("students",studentDtoList);
        return modelAndView;
    }
}
