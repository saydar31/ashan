package ru.itis.ashan.controllers.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.itis.ashan.entities.student.Student;
import ru.itis.ashan.entities.student.StudentDto;
import ru.itis.ashan.entities.user.UserDto;
import ru.itis.ashan.entities.user.UserModel;
import ru.itis.ashan.services.AuthenticationService;
import ru.itis.ashan.services.StudentService;
import ru.itis.ashan.services.TagService;

import java.util.List;

@Controller
public class StudentSelectionPageController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private TagService tagService;

    @Autowired
    private AuthenticationService authenticationService;

    @GetMapping("/students")
    public String getAllStudents(Model model, @RequestParam(value = "q", defaultValue = "") String searchWord,
                                  Authentication authentication) {

        List<StudentDto> students = null;
        UserModel userDto = null;

        if (authentication != null) {
            userDto = authenticationService.getUserModel(authentication);
        }

        if (searchWord.equals("")) {
            students = studentService.findAll();
        } else {
            students = tagService.selectStudents(searchWord);
        }
        model.addAttribute("students", students);
        model.addAttribute("user", userDto);
        return "selection_student";
    }
}
