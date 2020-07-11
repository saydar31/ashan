package ru.itis.ashan.entities.admin;

import lombok.*;
import lombok.experimental.SuperBuilder;
import ru.itis.ashan.entities.institute.Institute;
import ru.itis.ashan.entities.user.UserDto;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class AdminDto extends UserDto {

    private Institute institute;

    public static AdminDto castToDto(Admin admin) {
        return AdminDto.builder()
                .institute(admin.getInstitute())
                .mail(admin.getMail())
                .id(admin.getId())
                .role(admin.getRole())
                .state(admin.getState())
                .build();
    }
}
