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
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/init")
    @ResponseBody
    public String init() {
        Admin admin = Admin.builder()
                .mail("alex@mail.ru")
                .role(Role.ADMIN)
                .hashPassword(passwordEncoder.encode("1"))
                .state(State.CONFIRMED)
                .emailIsConfirmed(true)
                .build();
        userRepository.save(admin);
        return "ok";
    }
}
