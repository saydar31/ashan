package ru.itis.ashan.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.ashan.entities.employer.Employer;
import ru.itis.ashan.security.details.UserDetailsImpl;
import ru.itis.ashan.services.InterviewResultService;

@RestController
public class InterviewRestController {
    @Autowired
    private InterviewResultService interviewResultService;

    @PostMapping("/interview/student/{id:\\d+}/refuse")
    @PreAuthorize("hasAuthority('EMPLOYER')")
    public ResponseEntity<?> refuse(@PathVariable Long id, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        interviewResultService.refuse(id, (Employer) userDetails.getUser());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/interview/student/{id:\\d+}/accept")
    @PreAuthorize("hasAuthority('EMPLOYER')")
    public ResponseEntity<?> accept(@PathVariable Long id, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        interviewResultService.accept(id, (Employer) userDetails.getUser());
        return ResponseEntity.ok().build();
    }
}
