package ru.itis.ashan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.itis.ashan.entities.teacher.Teacher;

import java.util.List;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    @Query("SELECT t FROM Teacher t WHERE t.state='NOT_CONFIRMED'")
    List<Teacher> findAllNotConfirmed();

    @Query("SELECT t FROM Teacher t WHERE t.state='CONFIRMED'")
    List<Teacher> findAllConfirmed();
}
