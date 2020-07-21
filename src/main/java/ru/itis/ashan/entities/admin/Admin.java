package ru.itis.ashan.entities.admin;

import lombok.*;
import lombok.experimental.SuperBuilder;
import ru.itis.ashan.entities.user.UserModel;
import javax.persistence.*;

/*
 Аккаунт институт, содержит уникальный институт
 */

@SuperBuilder
@AllArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Admin extends UserModel {

    public static Admin castToModel(AdminDto adminDto){
        return Admin.builder()
                .id(adminDto.getId())
                .mail(adminDto.getMail())
                .role(adminDto.getRole())
                .state(adminDto.getState())
                .hashPassword(adminDto.getPassword())
                .build();
    }
}
