package ru.itis.ashan.entities.student;

import lombok.Data;

@Data
public class StudentEditForm {
    private String name;
    private String surname;
    private String patronymic;
    private Long teacherId;
    private String competence;

    private Long tag1Id;
    private Long tag2Id;
    private Long tag3Id;
    private Long tag4Id;
    private Long tag5Id;
}
