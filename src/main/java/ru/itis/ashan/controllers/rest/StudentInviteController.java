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
import ru.itis.ashan.services.JobInterviewService;

@RestController
public class StudentInviteController {
    @Autowired
    private JobInterviewService jobInterviewService;

    @PostMapping("/student/{id:\\d+}/invite")
    @PreAuthorize("hasAuthority('EMPLOYER')")
    public ResponseEntity<?> invite(@AuthenticationPrincipal UserDetailsImpl userDetails, @PathVariable Long id) {
        Employer employer = (Employer) userDetails.getUser();
        jobInterviewService.invite(id, employer);
        return ResponseEntity.ok().build();
    }
}
