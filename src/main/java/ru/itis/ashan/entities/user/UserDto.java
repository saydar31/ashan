package ru.itis.ashan.entities.user;

import lombok.*;
import lombok.experimental.SuperBuilder;
import ru.itis.ashan.entities.fileInfo.FileInfo;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class UserDto {

    private Long id;

    private String mail;

    private String password;

    private Role role;

    private State state;

    private Long mainPhotoId;

    public static UserDto castToDto(UserModel userModel){
        return UserDto.builder()
                .id(userModel.getId())
                .mail(userModel.getMail())
                .role(userModel.getRole())
                .state(userModel.getState())
                .mainPhotoId(FileInfo.getId(userModel.getMainPhoto()))
                .build();
    }
}
