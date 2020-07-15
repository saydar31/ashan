package ru.itis.ashan.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.ashan.entities.signIn.SignInDto;
import ru.itis.ashan.entities.token.TokenDto;
import ru.itis.ashan.services.SignInRestService;

@RestController
public class SignInRestController {

    @Autowired
    private SignInRestService signInService;

    @PostMapping(value = "/api/signIn")
    public ResponseEntity<TokenDto> signIn(@RequestBody SignInDto signInDto){

        return ResponseEntity.ok(signInService.signIn(signInDto));
    }

}
