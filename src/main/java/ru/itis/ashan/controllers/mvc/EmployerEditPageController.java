package ru.itis.ashan.controllers.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployerEditPageController {
    @GetMapping("/home/employer/edit")
    public ModelAndView getEditPage(){
        return null;
    }
}
