package ru.itis.ashan.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.ashan.entities.employer.Employer;
import ru.itis.ashan.security.details.UserDetailsImpl;
import ru.itis.ashan.services.AuthenticationService;
import ru.itis.ashan.services.InterviewResultService;

@RestController
public class InterviewRestController {
    @Autowired
    private InterviewResultService interviewResultService;

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/interview/student/{id:\\d+}/refuse")
    @PreAuthorize("hasAuthority('EMPLOYER')")
    public ResponseEntity<?> refuse(@PathVariable Long id, Authentication authentication) {
        interviewResultService.refuse(id, (Employer) authenticationService.getUserModel(authentication));
        return ResponseEntity.ok().build();
    }

    @PostMapping("/interview/student/{id:\\d+}/accept")
    @PreAuthorize("hasAuthority('EMPLOYER')")
    public ResponseEntity<?> accept(@PathVariable Long id, Authentication authentication) {
        interviewResultService.accept(id, (Employer) authenticationService.getUserModel(authentication));
        return ResponseEntity.ok().build();
    }
}
