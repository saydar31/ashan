package ru.itis.ashan.entities.teacher;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import ru.itis.ashan.entities.student.Student;
import ru.itis.ashan.entities.user.UserModel;

import javax.persistence.*;
import java.util.Set;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Teacher extends UserModel {


    @Column(nullable = false)
    private String surname;

    @Column(nullable = false)
    private String name;

    //отчество
    @Column(nullable = false)
    private String patronymic;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "teacher")
    private Set<Student> students;

    public static Teacher castToModel(TeacherDto teacherDto){
        return Teacher.builder()
                .surname(teacherDto.getSurname())
                .name(teacherDto.getName())
                .patronymic(teacherDto.getPatronymic())
                .mail(teacherDto.getMail())
                .hashPassword(teacherDto.getPassword())
                .role(teacherDto.getRole())
                .state(teacherDto.getState())
                .id(teacherDto.getId())
                .build();
    }
}
