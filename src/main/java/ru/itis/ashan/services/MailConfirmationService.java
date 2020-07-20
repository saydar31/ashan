package ru.itis.ashan.services;

import ru.itis.ashan.entities.user.UserModel;

public interface MailConfirmationService {
    String getConfirmationString(UserModel userModel);
    void confirm(String hash);
}
