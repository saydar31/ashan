package ru.itis.ashan.controllers.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itis.ashan.entities.admin.Admin;
import ru.itis.ashan.entities.user.Role;
import ru.itis.ashan.entities.user.State;
import ru.itis.ashan.repositories.AdminRepository;

@Controller
public class RootController {

    @GetMapping("/")
    public String redirectTo(Authentication authentication){

        if(authentication != null){
            return "redirect:/home";
        }
        return "redirect:/signIn";
    }
}
