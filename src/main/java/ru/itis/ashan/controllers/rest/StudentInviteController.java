package ru.itis.ashan.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.ashan.entities.employer.Employer;
import ru.itis.ashan.services.AuthenticationService;
import ru.itis.ashan.services.JobInterviewService;

@RestController
public class StudentInviteController {
    @Autowired
    private JobInterviewService jobInterviewService;

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/student/{id:\\d+}/invite")
    @PreAuthorize("hasAuthority('EMPLOYER')")
    public ResponseEntity<?> invite(Authentication authentication, @PathVariable Long id) {
        Employer employer = (Employer) authenticationService.getUserModel(authentication);
        jobInterviewService.invite(id, employer);
        return ResponseEntity.ok().build();
    }
}
