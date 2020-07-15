package ru.itis.ashan.entities.signUp;

import lombok.Data;

@Data
public class SignUpEmployerDto {

    private String companyName;
    private String mail;
    private String password;
    private String phoneNumber;
}
