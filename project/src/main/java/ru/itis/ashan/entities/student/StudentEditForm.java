package ru.itis.ashan.entities.student;

import lombok.Data;

@Data
public class StudentEditForm {
    private String name;
    private String surname;
    private String patronymic;
    private Long teacherId;
    private String competence;
}
