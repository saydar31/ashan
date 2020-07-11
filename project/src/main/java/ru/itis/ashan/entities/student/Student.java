package ru.itis.ashan.entities.student;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import ru.itis.ashan.entities.employer.Employer;
import ru.itis.ashan.entities.teacher.Teacher;
import ru.itis.ashan.entities.user.UserModel;

import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Student extends UserModel {

    @Column(nullable = false)
    private String surname;

    @Column(nullable = false)
    private String name;

    //отчество
    @Column(nullable = false)
    private String patronymic;

    @Column(nullable = false)
    private Integer course;

    @Column(nullable = false)
    private Integer group;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "employer_id")
    private Employer employer;
}
