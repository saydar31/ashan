package ru.itis.ashan.controllers.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.xml.MappingJackson2XmlView;
import ru.itis.ashan.entities.admin.Admin;
import ru.itis.ashan.entities.user.Role;
import ru.itis.ashan.entities.user.State;
import ru.itis.ashan.repositories.UserRepository;

@Controller
public class InitController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    private boolean state;

    @GetMapping("/init")
    public ModelAndView init() {
        Admin admin = Admin.builder()
                .role(Role.ADMIN)
                .state(State.CONFIRMED)
                .mail("alex@mail.ru")
                .emailIsConfirmed(true)
                .hashPassword(passwordEncoder.encode("1"))
                .build();
        if (state) {
            userRepository.save(admin);
            state = false;
        }
        return new ModelAndView(new MappingJackson2XmlView());
    }
}
