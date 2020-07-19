package ru.itis.ashan.entities.teacher;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class TeacherEditForm {

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

    private MultipartFile image;
}
