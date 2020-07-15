package ru.itis.ashan.services;

import ru.itis.ashan.entities.signIn.SignInDto;
import ru.itis.ashan.entities.token.TokenDto;

public interface SignInRestService {

    //метод возвращает токен
    TokenDto signIn(SignInDto signInDto);

    //метод возвращает токен, вместо пароля принимает хэш-пароль
    TokenDto signInWithHashPassword(SignInDto signInDto);
}
