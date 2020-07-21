package ru.itis.ashan.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.ashan.entities.teacher.Teacher;
import ru.itis.ashan.entities.user.UserModel;
import ru.itis.ashan.security.details.UserDetailsImpl;
import ru.itis.ashan.services.AuthenticationService;
import ru.itis.ashan.services.CompetenceConfirmationService;

@Controller
public class CompetenceRestController {

    @Autowired
    private CompetenceConfirmationService competenceConfirmationService;

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/competence/student/{id:\\d+}/confirm")
    @PreAuthorize("hasAnyAuthority('TEACHER')")
    public ResponseEntity<?> confirm(Authentication authentication, @PathVariable Long id) {
        UserModel user = authenticationService.getUserModel(authentication);
        Teacher teacher = (Teacher) user;
        competenceConfirmationService.confirm(id, teacher);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/competence/student/{id:\\d+}/refuse")
    @PreAuthorize("hasAnyAuthority('TEACHER')")
    public ResponseEntity<?> decline(Authentication authentication, @PathVariable("id") Long id) {
        UserModel user = authenticationService.getUserModel(authentication);
        Teacher teacher = (Teacher) user;
        competenceConfirmationService.refuse(id, teacher);
        return ResponseEntity.ok().build();
    }
}
