package ru.itis.ashan.controllers.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.ashan.entities.teacher.TeacherDto;
import ru.itis.ashan.services.TeacherService;

@Controller
public class TeacherPageController {

    @Autowired
    private TeacherService teacherService;

    @GetMapping("/teacher/{id:\\d+}")
    public ModelAndView getTeacherPage(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("teacher_page");
        TeacherDto teacherDto = teacherService.getTeacherById(id);
        modelAndView.addObject("teacher",teacherDto);
        return modelAndView;
    }
}
