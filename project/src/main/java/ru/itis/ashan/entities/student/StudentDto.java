package ru.itis.ashan.entities.student;

import lombok.*;
import lombok.experimental.SuperBuilder;
import ru.itis.ashan.entities.employer.EmployerDto;
import ru.itis.ashan.entities.fileInfo.FileInfo;
import ru.itis.ashan.entities.tag.Tag;
import ru.itis.ashan.entities.tag.TagDto;
import ru.itis.ashan.entities.teacher.TeacherDto;
import ru.itis.ashan.entities.user.UserDto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class StudentDto extends UserDto {

    private String surname;

    private String name;

    private String patronymic;

    private Integer course;

    private Integer groupNumber;

    private TeacherDto teacherDto;

    private EmployerDto employerDto;

    private CompetenceState competenceState;

    private String competence;

    private Set<TagDto> tagDtoSet;

    public static StudentDto castToDto(Student student) {
        StudentDto studentDto = StudentDto.builder()
                .surname(student.getSurname())
                .name(student.getName())
                .patronymic(student.getPatronymic())
                .course(student.getCourse())
                .groupNumber(student.getGroupNumber())
                .competenceState(student.getCompetenceState())
                .id(student.getId())
                .mail(student.getMail())
                .state(student.getState())
                .role(student.getRole())
                .competence(student.getCompetence())
                .mainPhotoId(FileInfo.getId(student.getMainPhoto()))
                .build();

        if(student.getEmployer() != null){
            studentDto.setEmployerDto(EmployerDto.getDto(student.getEmployer()));
        }

        if(student.getTeacher() != null){
            studentDto.setTeacherDto(TeacherDto.getDto(student.getTeacher()));
        }

        if (student.getTagSet() != null){
            studentDto.setTagDtoSet(new HashSet<>());

            for (Tag tag : student.getTagSet()){
                studentDto.tagDtoSet.add(TagDto.getDto(tag));
            }
        }

        return studentDto;
    }


    //не юзать, нужен для других классов
    public static StudentDto getDto(Student student) {
        return StudentDto.builder()
                .surname(student.getSurname())
                .name(student.getName())
                .patronymic(student.getPatronymic())
                .course(student.getCourse())
                .groupNumber(student.getGroupNumber())
                .competence(student.getCompetence())
                .competenceState(student.getCompetenceState())
                .id(student.getId())
                .mail(student.getMail())
                .state(student.getState())
                .role(student.getRole())
                .mainPhotoId(FileInfo.getId(student.getMainPhoto()))
                .build();
    }

    public static List<StudentDto> from(List<Student> students) {
        return students.stream().map(StudentDto::castToDto).collect(Collectors.toList());
    }
}
