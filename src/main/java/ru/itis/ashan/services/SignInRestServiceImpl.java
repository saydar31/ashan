package ru.itis.ashan.services;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.itis.ashan.entities.signIn.SignInDto;
import ru.itis.ashan.entities.token.TokenDto;
import ru.itis.ashan.entities.user.UserModel;
import ru.itis.ashan.repositories.UserRepository;

import java.util.Optional;

@Component
public class SignInRestServiceImpl implements SignInRestService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Value("${jwt.secret}")
    private String secret;

    @Override
    public TokenDto signIn(SignInDto signInDto) {

        Optional<UserModel> userModelOptional = userRepository.findUserModelByMail(signInDto.getMail());

        if(userModelOptional.isPresent()){
            UserModel userModel = userModelOptional.get();
            if(passwordEncoder.matches(signInDto.getPassword(), userModel.getHashPassword())){
                String token = Jwts.builder()
                     .setSubject(userModel.getId().toString())
                     .claim("mail", userModel.getMail())
                     .claim("role", userModel.getRole())
                     .claim("state", userModel.getState())
                     .signWith(SignatureAlgorithm.HS256, secret)
                     .compact();

                return new TokenDto(token);
            } else throw new AccessDeniedException("Wrong mail/password");
        } else throw new AccessDeniedException("User nor found");
    }

    @Override
    public TokenDto signInWithHashPassword(SignInDto signInDto) {
        Optional<UserModel> userModelOptional = userRepository.findUserModelByMail(signInDto.getMail());

        if(userModelOptional.isPresent()){
            UserModel userModel = userModelOptional.get();
            if(userModel.getHashPassword().equals(signInDto.getPassword())){
                String token = Jwts.builder()
                        .setSubject(userModel.getId().toString())
                        .claim("mail", userModel.getMail())
                        .claim("role", userModel.getRole())
                        .claim("state", userModel.getState())
                        .signWith(SignatureAlgorithm.HS256, secret)
                        .compact();

                return new TokenDto(token);
            } else throw new AccessDeniedException("Wrong mail/password");
        } else throw new AccessDeniedException("User nor found");
    }
}
