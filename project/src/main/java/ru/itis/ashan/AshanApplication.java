package ru.itis.ashan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.itis.ashan.bl.repositories.InstituteRepository;
import ru.itis.ashan.bl.repositories.StudentRepository;
import ru.itis.ashan.bl.repositories.TeacherRepository;
import ru.itis.ashan.bl.repositories.UserRepository;
import ru.itis.ashan.entities.institute.Institute;
import ru.itis.ashan.entities.student.CompetenceState;
import ru.itis.ashan.entities.student.Student;
import ru.itis.ashan.entities.student.StudentDto;
import ru.itis.ashan.entities.teacher.Teacher;
import ru.itis.ashan.entities.user.Role;

@SpringBootApplication
public class AshanApplication {

    public static void main(String[] args) {
        SpringApplication.run(AshanApplication.class, args);

    }

}
