package ru.itis.ashan.entities.user;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Inheritance(strategy = InheritanceType.JOINED)
@Entity
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String mail;

    @Column(nullable = false)
    private String hashPassword;

    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    private State state;

    public static UserModel castToModel(UserDto userDto){
        return UserModel.builder()
                .hashPassword(userDto.getPassword())
                .id(userDto.getId())
                .mail(userDto.getMail())
                .role(userDto.getRole())
                .state(userDto.getState())
                .build();
    }
}
