package ru.itis.ashan.entities.teacher;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import ru.itis.ashan.entities.fileInfo.FileInfo;
import ru.itis.ashan.entities.student.Student;
import ru.itis.ashan.entities.student.StudentDto;
import ru.itis.ashan.entities.user.UserDto;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class TeacherDto extends UserDto {

    private String surname;

    private String name;

    private String patronymic;

    private Set<StudentDto> studentDtoSet;

    private String education;
    //занимаемая должность
    private String positionHeld;
    //знания языков
    private String knowledgeOfLanguages;
    //дополнительная информация
    private String additionInformation;

    public static TeacherDto castToDto(Teacher teacher){
        TeacherDto teacherDto =  TeacherDto.builder()
                .surname(teacher.getSurname())
                .name(teacher.getName())
                .patronymic(teacher.getPatronymic())
                .education(teacher.getEducation())
                .positionHeld(teacher.getPositionHeld())
                .knowledgeOfLanguages(teacher.getKnowledgeOfLanguages())
                .additionInformation(teacher.getAdditionInformation())
                .mail(teacher.getMail())
                .id(teacher.getId())
                .role(teacher.getRole())
                .state(teacher.getState())
                .mainPhotoId(FileInfo.getId(teacher.getMainPhoto()))
                .build();
        if(teacher.getStudents() != null) {
            teacherDto.setStudentDtoSet(new HashSet<>());
            for (Student student : teacher.getStudents()) {
                teacherDto.studentDtoSet.add(StudentDto.getDto(student));
            }
        }
        return teacherDto;
    }

    //не юзать, используется для других классов
    public static TeacherDto getDto(Teacher teacher){
        return TeacherDto.builder()
                .surname(teacher.getSurname())
                .name(teacher.getName())
                .patronymic(teacher.getPatronymic())
                .education(teacher.getEducation())
                .positionHeld(teacher.getPositionHeld())
                .knowledgeOfLanguages(teacher.getKnowledgeOfLanguages())
                .additionInformation(teacher.getAdditionInformation())
                .mail(teacher.getMail())
                .id(teacher.getId())
                .role(teacher.getRole())
                .state(teacher.getState())
                .mainPhotoId(FileInfo.getId(teacher.getMainPhoto()))
                .build();
    }

    public static List<TeacherDto> from(List<Teacher> teachers) {
        return teachers.stream().map(TeacherDto::castToDto).collect(Collectors.toList());
    }
}
