package ru.itis.ashan.entities.user;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class UserDto {

    private Long id;

    private String mail;

    private String password;

    private Role role;

    private State state;

    public static UserDto castToDto(UserModel userModel){
        return UserDto.builder()
                .id(userModel.getId())
                .mail(userModel.getMail())
                .role(userModel.getRole())
                .state(userModel.getState())
                .build();
    }
}
