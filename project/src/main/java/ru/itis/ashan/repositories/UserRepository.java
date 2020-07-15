package ru.itis.ashan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.ashan.entities.user.UserModel;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserModel, Long> {

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("UPDATE UserModel u SET u.state='CONFIRMED' where u.id =:id")
    void confirmUser(@Param("id") Long id);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("UPDATE UserModel u SET u.state='REFUSED' where u.id =:id")
    void refuseUser(@Param("id") Long id);

    Optional<UserModel> findUserModelByMail(String mail);
}
