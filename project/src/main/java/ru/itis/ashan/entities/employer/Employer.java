package ru.itis.ashan.entities.employer;


import lombok.*;
import lombok.experimental.SuperBuilder;
import ru.itis.ashan.entities.student.Student;
import ru.itis.ashan.entities.user.UserModel;

import javax.persistence.*;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Employer extends UserModel {

    @Column(nullable = false)
    private String companyName;

    private String phoneNumber;;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "employer")
    private Set<Student> students;

    public static Employer castToModel(EmployerDto employer){
        return Employer.builder()
                .companyName(employer.getCompanyName())
                .mail(employer.getMail())
                .id(employer.getId())
                .role(employer.getRole())
                .state(employer.getState())
                .hashPassword(employer.getPassword())
                .build();
    }

}
