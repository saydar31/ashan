package ru.itis.ashan.entities.student;


import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import ru.itis.ashan.entities.employer.Employer;
import ru.itis.ashan.entities.fileInfo.FileInfo;
import ru.itis.ashan.entities.tag.Tag;
import ru.itis.ashan.entities.teacher.Teacher;
import ru.itis.ashan.entities.user.UserModel;

import javax.persistence.*;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Getter
@Setter
@ToString(exclude = {"employer","invitingEmployers","teacher"})
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
    private Integer groupNumber;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "employer_id")
    private Employer employer;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Employer> invitingEmployers;

    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    private CompetenceState competenceState;

    private String competence;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Tag> tagSet;


    public static Student castToModel(StudentDto studentDto) {
        return Student.builder()
                .surname(studentDto.getSurname())
                .name(studentDto.getName())
                .patronymic(studentDto.getPatronymic())
                .course(studentDto.getCourse())
                .groupNumber(studentDto.getGroupNumber())
                .competenceState(studentDto.getCompetenceState())
                .mail(studentDto.getMail())
                .id(studentDto.getId())
                .state(studentDto.getState())
                .role(studentDto.getRole())
                .hashPassword(studentDto.getPassword())
                .build();
    }
}
