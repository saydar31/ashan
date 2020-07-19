package ru.itis.ashan.controllers.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.ashan.services.MailConfirmationService;

@Controller
public class EmailConfirmController {
    @Autowired
    private MailConfirmationService mailConfirmationService;
    @GetMapping("/emailConfirm/{hash:.+}")
    public ModelAndView confirm(@PathVariable String hash){
        mailConfirmationService.confirm(hash);
        return new ModelAndView("redirect:/signIn");
    }
}
