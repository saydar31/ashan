package ru.itis.ashan.entities.tag;

import lombok.*;
import ru.itis.ashan.entities.student.Student;
import ru.itis.ashan.entities.user.UserModel;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Tag implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String tagName;

    @ManyToMany(mappedBy = "tagSet", fetch = FetchType.EAGER)
    private Set<Student> studentSet;

}
