package ru.itis.ashan.entities.admin;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import ru.itis.ashan.entities.user.UserModel;

import javax.persistence.*;

/*
 Аккаунт институт, содержит уникальный институт
 */
@Setter
@Getter
@SuperBuilder
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
