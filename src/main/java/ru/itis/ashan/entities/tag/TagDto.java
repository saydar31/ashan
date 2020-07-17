package ru.itis.ashan.entities.tag;

import lombok.*;
import ru.itis.ashan.entities.student.Student;
import ru.itis.ashan.entities.student.StudentDto;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TagDto {

    private Long id;
    private String tagName;
    private Set<StudentDto> studentDtoSet;

    public static TagDto castToDto(Tag tag) {
        TagDto tagDto = TagDto.builder()
                .id(tag.getId())
                .tagName(tag.getTagName())
                .build();

        if (tag.getStudentSet() != null) {
            Set<StudentDto> studentDtoSet = new HashSet<>();

            for (Student student : tag.getStudentSet()) {
                studentDtoSet.add(StudentDto.getDto(student));
            }
            tagDto.setStudentDtoSet(studentDtoSet);
        }
        return tagDto;
    }

    public static TagDto getDto(Tag tag) {
        return TagDto.builder()
                .id(tag.getId())
                .tagName(tag.getTagName())
                .build();
    }
}
