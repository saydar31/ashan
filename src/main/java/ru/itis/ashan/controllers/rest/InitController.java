package ru.itis.ashan.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.ashan.entities.admin.Admin;
import ru.itis.ashan.entities.employer.Employer;
import ru.itis.ashan.entities.teacher.Teacher;
import ru.itis.ashan.entities.user.Role;
import ru.itis.ashan.entities.user.State;
import ru.itis.ashan.repositories.UserRepository;

@RestController
public class InitController {
    private boolean state = true;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/initAdmin")
    @ResponseBody
    public String init() {
        if (state) {
            Admin admin = Admin.builder()
                    .mail("alex@mail.ru")
                    .emailIsConfirmed(true)
                    .hashPassword(passwordEncoder.encode("1"))
                    .state(State.CONFIRMED)
                    .role(Role.ADMIN)
                    .build();
            userRepository.save(admin);
            Teacher teacher = Teacher.builder()
                    .mail("teacher@ashan.ru")
                    .hashPassword(passwordEncoder.encode("1"))
                    .emailIsConfirmed(true)
                    .state(State.CONFIRMED)
                    .role(Role.TEACHER)
                    .surname("Арсланов")
                    .name("Марат")
                    .patronymic("Мирзаевич")
                    .build();
            userRepository.save(teacher);
            Employer employer = Employer.builder()
                    .mail("employer@ashan.ru")
                    .emailIsConfirmed(true)
                    .hashPassword(passwordEncoder.encode("1"))
                    .state(State.CONFIRMED)
                    .role(Role.EMPLOYER)
                    .phoneNumber("88005553535")
                    .companyName("mail ru gr")
                    .build();
            userRepository.save(employer);
            state = false;
        }
        return "admin initialized";
    }
}
