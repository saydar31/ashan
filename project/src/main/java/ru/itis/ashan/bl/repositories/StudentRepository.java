package ru.itis.ashan.bl.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.ashan.entities.student.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
