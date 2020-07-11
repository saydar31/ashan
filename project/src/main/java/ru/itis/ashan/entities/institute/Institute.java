package ru.itis.ashan.entities.institute;

import lombok.*;
import ru.itis.ashan.entities.admin.Admin;
import ru.itis.ashan.entities.student.Student;
import ru.itis.ashan.entities.teacher.Teacher;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Institute {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "institute", fetch = FetchType.EAGER)
    private Set<Teacher> teachers;

    @OneToOne(mappedBy = "institute")
    private Admin admin;

}
