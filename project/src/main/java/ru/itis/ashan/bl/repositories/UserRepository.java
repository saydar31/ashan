package ru.itis.ashan.bl.repositories;

import org.apache.tomcat.jni.User;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.ashan.entities.user.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Long> {
}
