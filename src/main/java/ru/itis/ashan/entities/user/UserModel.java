package ru.itis.ashan.entities.user;

import lombok.*;
import lombok.experimental.SuperBuilder;
import ru.itis.ashan.entities.fileInfo.FileInfo;

import javax.persistence.*;
import java.io.Serializable;

@Inheritance(strategy = InheritanceType.JOINED)
@Entity
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserModel implements Serializable {

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


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "photo_id")
    private FileInfo mainPhoto;

    @Column(nullable = false)
    private boolean emailIsConfirmed;


    //хранит токен для rest запросов
    @Transient
    private String token;

    public static UserModel castToModel(UserDto userDto) {
        return UserModel.builder()
                .hashPassword(userDto.getPassword())
                .id(userDto.getId())
                .mail(userDto.getMail())
                .role(userDto.getRole())
                .state(userDto.getState())
                .build();
    }
}
