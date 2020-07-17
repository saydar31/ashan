package ru.itis.ashan.entities.rest.request;

import lombok.Data;

@Data
public class TagRequestDto {

    private Long tagId;
    private String tagName;
}
