package ru.itis.ashan.bl.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.ashan.entities.teacher.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
