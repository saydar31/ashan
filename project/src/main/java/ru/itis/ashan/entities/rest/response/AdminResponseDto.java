package ru.itis.ashan.entities.rest.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AdminResponseDto {

    private String state;
    private String description;
}
