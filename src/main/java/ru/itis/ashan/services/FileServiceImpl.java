package ru.itis.ashan.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.MultipartFile;
import ru.itis.ashan.entities.fileInfo.FileInfo;
import ru.itis.ashan.entities.user.UserDto;
import ru.itis.ashan.entities.user.UserModel;
import ru.itis.ashan.helpers.FileHelper;
import ru.itis.ashan.repositories.FileInfoRepository;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Optional;

@Component
public class FileServiceImpl implements FileService {

    @Autowired
    private FileHelper helper;

    @Autowired
    private FileInfoRepository fileInfoRepository;

    @Override
    public FileInfo save(MultipartFile file, UserDto user) {

        if (file != null && file.getContentType() != null && !file.getContentType().toLowerCase().startsWith("image"))
            throw new MultipartException("not img");

        FileInfo fileInfo = helper.convert(file, user);
        UserModel userModel = UserModel.castToModel(user);
        fileInfo.setUser(userModel);
        helper.uploadFile(fileInfo, file);
        return fileInfoRepository.save(fileInfo);
    }

    @Override
    public FileInfo save(MultipartFile file, UserModel user) {
        if (file != null && file.getContentType() != null && !file.getContentType().toLowerCase().startsWith("image"))
            throw new MultipartException("not img");

        FileInfo fileInfo = helper.convert(file);
        helper.uploadFile(fileInfo, file);
        return fileInfoRepository.save(fileInfo);
    }

    @Override
    public byte[] downloadFileById(Long id) {

        if (id == null) {
            return null;
        }

        Optional<FileInfo> fileInfoOptional = fileInfoRepository.findById(id);
        if (!fileInfoOptional.isPresent()) {
            return null;
        }

        File file = helper.downloadFile(fileInfoOptional.get());

        try {
            return Files.readAllBytes(file.toPath());
        } catch (IOException e){
            throw new IllegalStateException(e);
        }
    }
}
