package ru.itis.ashan.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.omg.CORBA.portable.ValueOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.context.WebApplicationContext;
import ru.itis.ashan.entities.tag.Tag;
import ru.itis.ashan.entities.tag.TagDto;
import ru.itis.ashan.entities.teacher.Teacher;
import ru.itis.ashan.entities.user.Role;
import ru.itis.ashan.entities.user.State;
import ru.itis.ashan.repositories.UserRepository;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Optional;

@SpringBootTest
public class TagServiceImplTest {

    private TagService tagService;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    void setUp(){
        tagService = webApplicationContext.getBean(TagService.class);
        userRepository = webApplicationContext.getBean(UserRepository.class);
    }


    @Test
    void saveNewTag(){
        String tagName = "java";
        assertTrue(tagService.addNewTag(tagName).isPresent());
    }

    @Test
    void saveExistTag(){
        String tagName = "java1";
        tagService.addNewTag(tagName);
        tagService.addNewTag(tagName);
        assertFalse(tagService.addNewTag(tagName).isPresent());
    }

    @Test
    void getAllTag(){
        System.out.println(tagService.getAllTags());
    }

    @Test
    void isExistWithExistTagName(){
        String tagName = "java1ews";
        tagService.addNewTag(tagName);
        assertTrue(tagService.tagIsExist(tagName));
    }

    @Test
    void isExistWithExistTagId(){
        String tagName = "java2asdafsag";
        Optional<TagDto> optionalTagDto = tagService.addNewTag(tagName);
        assertTrue(tagService.tagIsExist(optionalTagDto.get().getId()));
    }

    @Test
    void isExistWithNotExistTagName(){
        assertFalse(tagService.tagIsExist("notExistName124234"));
    }

    @Test
    void isExistWithNotExistTagId(){
        assertFalse(tagService.tagIsExist(12412414L));
    }


}
