package ru.itis.ashan.entities.admin;

import lombok.*;
import lombok.experimental.SuperBuilder;
import ru.itis.ashan.entities.user.UserDto;

@Data
@SuperBuilder
public class AdminDto extends UserDto {

    public static AdminDto castToDto(Admin admin) {
        return AdminDto.builder()
                .mail(admin.getMail())
                .id(admin.getId())
                .role(admin.getRole())
                .state(admin.getState())
                .build();
    }
}
