package ru.itis.ashan.controllers.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import ru.itis.ashan.entities.rest.request.TagRequestDto;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
public class TagPanelRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper objectMapper;

    private String authorization;

    private TagRequestDto tagRequestDto;

    @BeforeEach
    void init() {
        objectMapper = new ObjectMapper();
        authorization = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI1IiwibWFpbCI6ImFsZXhAbWFpbC5ydSIsInJvbGUiOiJBRE1JTiIsInN0YXRlIjoiQ09ORklSTUVEIn0.ldgzVmhRlpfOpiCkG32GoeYATUoGu5cwLxSkw8Vi0JY";
        tagRequestDto = new TagRequestDto();
    }

    @SneakyThrows
    @Test
    void addTag() {
        tagRequestDto.setTagName("java");
        mockMvc.perform(post("/api/admin/add_tag")
                .header("Authorization", authorization)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(tagRequestDto))
        ).andExpect(status().isOk());
    }

    @SneakyThrows
    @Test
    void deleteTag() {
        tagRequestDto.setTagName(null);
        tagRequestDto.setTagId(10L);
        mockMvc.perform(post("/api/admin/delete_tag")
                .header("Authorization", authorization)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(tagRequestDto))
        ).andExpect(status().isOk());
    }
}
