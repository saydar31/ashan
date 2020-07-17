package ru.itis.ashan.entities.rest.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TagResponseDto {

    private String state;
    private String description;
}
