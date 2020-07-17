package ru.itis.ashan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.ashan.entities.student.Student;
import ru.itis.ashan.entities.tag.Tag;

import java.util.List;
import java.util.Optional;

public interface TagRepository extends JpaRepository<Tag, Long> {

    Optional<Tag> findByTagName(String tagName);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM student_tag_set WHERE student_set_id=:userId", nativeQuery = true)
    void deleteAllTagsByUserId(@Param("userId") Long userId);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "DELETE FROM student_tag_set WHERE tag_set_id=:tagId", nativeQuery = true)
    void deleteAllUsersByTagId(@Param("tagId") Long tagId);

    @Query("SELECT s FROM Student s join s.tagSet tag where tag.tagName=:tagName")
    List<Student> findStudentWithTagName(@Param("tagName") String tagName);
}
