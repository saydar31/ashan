package ru.itis.ashan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.ashan.entities.student.Student;
import ru.itis.ashan.entities.teacher.Teacher;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("SELECT s FROM Student s WHERE s.state='NOT_CONFIRMED'")
    List<Student> findAllNotConfirmed();

    @Query("SELECT s FROM Student s WHERE s.competenceState='NOT_CONFIRMED' and s.teacher=:teacher")
    List<Student> findAllNotConfirmedCompetenceByTeacher(@Param("teacher") Teacher teacher);

    @Query("SELECT s FROM Student s WHERE s.competenceState='CONFIRMED' and s.teacher=:teacher")
    List<Student> findAllConfirmedCompetenceByTeacher(@Param("teacher") Teacher teacher);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("UPDATE Student s SET s.competenceState='CONFIRMED' where s.id=:id")
    void confirmCompetence(@Param("id") Long id);

    @Query("SELECT COUNT(s) FROM Student s WHERE s.id=:id and s.teacher=:teacher")
    Long existStudentByIdAndTeacher(@Param("id") Long id, @Param("teacher") Teacher teacher);
}
