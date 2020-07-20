package ru.itis.ashan.services;

import org.springframework.web.multipart.MultipartFile;
import ru.itis.ashan.entities.fileInfo.FileInfo;
import ru.itis.ashan.entities.user.UserDto;
import ru.itis.ashan.entities.user.UserModel;

public interface FileService {
    FileInfo save(MultipartFile file, UserDto userDto);
    FileInfo save(MultipartFile file, UserModel userDto);
    byte[] downloadFileById(Long id);
}
