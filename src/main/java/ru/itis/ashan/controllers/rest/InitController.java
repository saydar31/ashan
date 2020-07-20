package ru.itis.ashan.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.ashan.entities.admin.Admin;
import ru.itis.ashan.entities.user.Role;
import ru.itis.ashan.entities.user.State;
import ru.itis.ashan.repositories.UserRepository;

@RestController
public class InitController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    private boolean isReady =true;

    @GetMapping("/initAdmin")
    @ResponseBody
    public String init() {
        if (isReady) {
            Admin admin = Admin.builder()
                    .emailIsConfirmed(true)
                    .state(State.CONFIRMED)
                    .role(Role.ADMIN)
                    .mail("alex@mail.ru")
                    .hashPassword(passwordEncoder.encode("1"))
                    .build();
            userRepository.save(admin);
            isReady=false;
            return admin.getMail();
        } else {
            return "admin is ready";
        }
    }
}
