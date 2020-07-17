package ru.itis.ashan.controllers.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.itis.ashan.entities.student.StudentDto;
import ru.itis.ashan.security.details.UserDetailsImpl;
import ru.itis.ashan.services.StudentService;

@Controller
public class StudentPageController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/student/{id:.+}")
    private String getStudentPage(@PathVariable("id") Long id, Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        StudentDto studentDto = studentService.getStudentById(id);
        model.addAttribute("student", studentDto);
        if (userDetails != null) {
            String role = userDetails.getUser().getRole().name();
            model.addAttribute("role", role);
        }
        return "student_page";
    }
}
