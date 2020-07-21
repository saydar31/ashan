package ru.itis.ashan.entities.employer;


import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import ru.itis.ashan.entities.student.Student;
import ru.itis.ashan.entities.user.UserModel;

import javax.persistence.*;
import java.util.Set;


@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Employer extends UserModel {

    @Column(nullable = false)
    private String companyName;

    @Column(nullable = false)
    private String phoneNumber;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "employer")
    private Set<Student> students;

    @ManyToMany(fetch = FetchType.EAGER,mappedBy = "invitingEmployers",cascade = {CascadeType.PERSIST})
    private Set<Student> invitedStudents;

    public static Employer castToModel(EmployerDto employer) {
        return Employer.builder()
                .companyName(employer.getCompanyName())
                .mail(employer.getMail())
                .id(employer.getId())
                .phoneNumber(employer.getPhoneNumber())
                .role(employer.getRole())
                .state(employer.getState())
                .hashPassword(employer.getPassword())
                .build();
    }

}
