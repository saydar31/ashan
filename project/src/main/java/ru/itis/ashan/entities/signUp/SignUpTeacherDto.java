package ru.itis.ashan.entities.signUp;

import lombok.Data;

@Data
public class SignUpTeacherDto {

    private String name;
    private String surname;
    private String patronymic;

    private String mail;
    private String password;
}
