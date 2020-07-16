package ru.itis.ashan.controllers.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itis.ashan.entities.teacher.Teacher;
import ru.itis.ashan.security.details.UserDetailsImpl;
import ru.itis.ashan.services.TeacherService;

@Controller
public class TeacherPageController {

    @Autowired
    TeacherService teacherService;

    private Teacher teacher;
    @PreAuthorize("hasAuthority('TEACHER')")
    @GetMapping("/teacher/home")
    public String getTeacherData(Authentication authentication, Model model){
        UserDetailsImpl userDetail = (UserDetailsImpl) authentication.getPrincipal();
        teacher = (Teacher) userDetail.getUser();
        model.addAttribute("teacher", teacher);
        model.addAttribute("students", teacherService.getAllStudentsByTeacher(teacher));
        return "profileTeacher";
    }
}
