package ru.itis.ashan.entities.teacher;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import ru.itis.ashan.entities.student.StudentDto;
import ru.itis.ashan.entities.user.UserDto;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class TeacherEditDto extends UserDto {

    private String surname;

    private String name;

    private String patronymic;

    private String education;
    //занимаемая должность
    private String positionHeld;
    //знания языков
    private String knowledgeOfLanguages;
    //дополнительная информация
    private String additionInformation;

}
