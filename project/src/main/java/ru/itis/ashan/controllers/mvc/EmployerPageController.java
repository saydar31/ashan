package ru.itis.ashan.controllers.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.ashan.services.EmployerService;

@Controller
public class EmployerPageController {

    @Autowired
    private EmployerService employerService;

    @GetMapping("/employer/{id:\\d+}")
    public ModelAndView getEmployeePage(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("employer_page");
        modelAndView.addObject("employer", employerService.getById(id));
        return modelAndView;
    }
}
