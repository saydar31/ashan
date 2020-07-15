package ru.itis.ashan.controllers.mvc;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
