package ru.itis.ashan.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itis.ashan.entities.admin.Admin;
import ru.itis.ashan.entities.user.Role;
import ru.itis.ashan.entities.user.State;
import ru.itis.ashan.repositories.AdminRepository;

@Controller
public class InitAdminController {
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    private boolean state = true;

    @GetMapping("/initAdmin")
    public ResponseEntity<?> init() {
        if (state) {
            Admin admin = Admin.builder()
                    .mail("alex@mail.ru")
                    .hashPassword(passwordEncoder.encode("1"))
                    .role(Role.ADMIN)
                    .state(State.CONFIRMED)
                    .build();
            adminRepository.save(admin);
            state = false;
        }
        return ResponseEntity.ok("admin intialized");
    }
}
