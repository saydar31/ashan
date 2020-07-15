package ru.itis.ashan.controllers.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itis.ashan.entities.student.StudentDto;
import ru.itis.ashan.services.StudentService;
import java.util.List;

@Controller
public class StudentSelectionPageController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    private String getAllStudents(Model model) {
        List<StudentDto> students = studentService.findAll();
        model.addAttribute("students", students);
        return "selection_student";
    }
}
