package ru.itis.ashan.controllers.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockBeans;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.ShallowEtagHeaderFilter;
import ru.itis.ashan.entities.admin.Admin;
import ru.itis.ashan.entities.rest.request.AdminRequestDto;
import ru.itis.ashan.entities.user.Role;
import ru.itis.ashan.entities.user.State;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.*;

@AutoConfigureMockMvc
@SpringBootTest
public class AdminRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper objectMapper;


    @BeforeEach
    void init() {
        objectMapper = new ObjectMapper();
    }

    @SneakyThrows
    @Test
    void getNotConfirmedStudents() {
        mockMvc.perform(get("/api/admin/not_confirmed_students").header("Authorization", "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI1IiwibWFpbCI6ImFsZXhAbWFpbC5ydSIsInJvbGUiOiJBRE1JTiIsInN0YXRlIjoiQ09ORklSTUVEIn0.ldgzVmhRlpfOpiCkG32GoeYATUoGu5cwLxSkw8Vi0JY"))
                .andExpect(status().isOk());
    }

    @SneakyThrows
    @Test
    void confirmUser() {
        AdminRequestDto adminRequestDto = new AdminRequestDto();
        adminRequestDto.setId(1L);

        mockMvc.perform(post("/api/admin/confirm_user")
                .header("Authorization", "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI1IiwibWFpbCI6ImFsZXhAbWFpbC5ydSIsInJvbGUiOiJBRE1JTiIsInN0YXRlIjoiQ09ORklSTUVEIn0.ldgzVmhRlpfOpiCkG32GoeYATUoGu5cwLxSkw8Vi0JY")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(adminRequestDto))
        ).andExpect(status().isOk());
    }


    @SneakyThrows
    @Test
    void refuseUser() {
        AdminRequestDto adminRequestDto = new AdminRequestDto();
        adminRequestDto.setId(1L);

        mockMvc.perform(post("/api/admin/refuse_user")
                .header("Authorization", "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI1IiwibWFpbCI6ImFsZXhAbWFpbC5ydSIsInJvbGUiOiJBRE1JTiIsInN0YXRlIjoiQ09ORklSTUVEIn0.ldgzVmhRlpfOpiCkG32GoeYATUoGu5cwLxSkw8Vi0JY")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(adminRequestDto))
        ).andExpect(status().isOk());
    }

}
