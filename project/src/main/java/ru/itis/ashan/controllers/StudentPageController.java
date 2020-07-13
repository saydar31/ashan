package ru.itis.ashan.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.itis.ashan.entities.student.Student;
import ru.itis.ashan.services.StudentService;

@Controller
public class StudentPageController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/students/{id}")
    @PreAuthorize("permitAll()")
    private String getStudentPage(@PathVariable Long id, Model model) {
        Student student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        return "student_page";
    }
}
