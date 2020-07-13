package ru.itis.ashan.controllers.mvc;

<<<<<<< HEAD
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
=======
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itis.ashan.entities.admin.Admin;
import ru.itis.ashan.entities.user.Role;
import ru.itis.ashan.entities.user.State;
import ru.itis.ashan.repositories.AdminRepository;
>>>>>>> 678de59d103cce8a7a0067fd535e78768ea85834

@Controller
public class RootController {

    @GetMapping("/")
    public String redirectTo(Authentication authentication){
<<<<<<< HEAD
=======

>>>>>>> 678de59d103cce8a7a0067fd535e78768ea85834
        if(authentication != null){
            return "redirect:/home";
        }
        return "redirect:/signIn";
    }
}
