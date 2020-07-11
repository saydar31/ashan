package ru.itis.ashan.entities.employer;


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
public class Employer extends UserModel {

    @Column(nullable = false)
    private String companyName;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "employer")
    private Set<Student> students;
}
