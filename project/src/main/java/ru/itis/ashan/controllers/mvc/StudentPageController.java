package ru.itis.ashan.controllers.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.itis.ashan.entities.student.Student;
import ru.itis.ashan.entities.student.StudentDto;
import ru.itis.ashan.services.AdminService;
import ru.itis.ashan.services.StudentService;

@Controller
public class StudentPageController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private AdminService adminService;

    @GetMapping("/student/{id:.+}")
    private String getStudentPage(@PathVariable("id") Long id, Model model) {
        System.out.println(adminService);
        StudentDto studentDto = studentService.getStudentById(id);
        model.addAttribute("student", studentDto);
        return "student_page";
    }
}
