package ru.itis.ashan.services;

import ru.itis.ashan.entities.user.UserDto;

import java.util.Optional;

public interface UserService {

    Optional<UserDto> findUserModelById(Long id);
}
