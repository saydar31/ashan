package ru.itis.ashan.entities.admin;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import ru.itis.ashan.entities.institute.Institute;
import ru.itis.ashan.entities.user.UserModel;

import javax.persistence.*;

/*
 Аккаунт институт, содержит уникальный институт
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Admin extends UserModel {

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "institute_id", nullable = false, unique = true)
    private Institute institute;
}
