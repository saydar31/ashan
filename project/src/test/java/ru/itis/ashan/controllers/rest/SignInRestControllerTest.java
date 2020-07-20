package ru.itis.ashan.controllers.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import ru.itis.ashan.entities.signIn.SignInDto;
import ru.itis.ashan.entities.token.TokenDto;
import ru.itis.ashan.services.SignInRestServiceImpl;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;


@SpringBootTest
@AutoConfigureMockMvc
class SignInRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SignInRestServiceImpl signInService;

    private SignInDto signInDto;

    @BeforeEach
    public void setUp() {
        signInDto = new SignInDto();
        signInDto.setMail("saidar31@yandex.ru");
        signInDto.setPassword("qwerty007");
        TokenDto tokenDto = new TokenDto("token");
        Mockito.when(signInService.signIn(signInDto)).thenReturn(tokenDto);
    }

    @SneakyThrows
    @WithMockUser
    @Test
    void signIn() {
        ObjectMapper objectMapper = new ObjectMapper();
        signInDto.setPassword("qwerty007");
        String content = objectMapper.writeValueAsString(signInDto);
        mockMvc.perform(
                post("/api/signIn")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content)
        ).andExpect(MockMvcResultMatchers.status().isOk());
    }
}