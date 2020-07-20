package ru.itis.ashan.services;

import ru.itis.ashan.entities.user.UserModel;

public interface WelcomeLetterService {
    void sendWelcomeLetter(UserModel userModel);
}
