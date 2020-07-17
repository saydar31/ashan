package ru.itis.ashan.services;

import ru.itis.ashan.entities.student.StudentDto;
import ru.itis.ashan.entities.tag.TagDto;
import java.util.List;
import java.util.Optional;

public interface TagService {

    Optional<TagDto> addNewTag(String tagName);
    boolean deleteTag(Long id);
    boolean tagIsExist(Long id);
    boolean tagIsExist(String tagName);
    List<TagDto> getAllTags();

    List<StudentDto> selectStudents(String searchText);
}
