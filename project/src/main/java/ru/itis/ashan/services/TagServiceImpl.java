package ru.itis.ashan.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.ashan.entities.student.Student;
import ru.itis.ashan.entities.student.StudentDto;
import ru.itis.ashan.entities.tag.Tag;
import ru.itis.ashan.entities.tag.TagDto;
import ru.itis.ashan.repositories.TagRepository;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagRepository tagRepository;


    @Override
    public Optional<TagDto> addNewTag(String tagName) {
        if (tagIsExist(tagName)) {
            return Optional.empty();
        }
        Tag tag = tagRepository.save(
                Tag.builder()
                        .tagName(tagName)
                        .build());
        return Optional.of(TagDto.castToDto(tag));
    }

    @Override
    public boolean deleteTag(Long id) {
        if (!tagIsExist(id)) {
            return false;
        }
        tagRepository.deleteAllUsersByTagId(id);
        System.out.println("delete");
        tagRepository.deleteById(id);
        return true;
    }

    @Override
    public boolean tagIsExist(Long id) {
        return tagRepository.findById(id).isPresent();
    }

    @Override
    public boolean tagIsExist(String tagName) {
        return tagRepository.findByTagName(tagName).isPresent();
    }

    @Override
    public List<TagDto> getAllTags() {
        List<Tag> tagList = tagRepository.findAll();
        List<TagDto> tagDtoList = new LinkedList<>();

        for (Tag tag : tagList) {
            tagDtoList.add(TagDto.castToDto(tag));
        }
        return tagDtoList;
    }

    @Override
    public List<StudentDto> selectStudents(String searchText) {
        searchText = searchText.trim();
        List<Student> studentList = tagRepository.findStudentWithTagName(searchText);
        List<StudentDto> studentDtoList = new LinkedList<>();

        for (Student student : studentList) {
            studentDtoList.add(StudentDto.castToDto(student));
        }
        return studentDtoList;
    }

}
