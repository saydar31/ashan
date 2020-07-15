package ru.itis.ashan.entities.signUp;

import lombok.Data;

@Data
public class SignUpStudentDto {

    private String name;
    private String surname;
    private String patronymic;
    private Integer course;
    private Integer groupNumber;
    private String mail;
    private String password;
}
