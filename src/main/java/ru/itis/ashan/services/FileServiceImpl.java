package ru.itis.ashan.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import ru.itis.ashan.entities.fileInfo.FileInfo;
import ru.itis.ashan.entities.user.UserModel;
import ru.itis.ashan.helpers.FileHelper;
import ru.itis.ashan.repositories.FileInfoRepository;

@Component
public class FileServiceImpl implements FileService {

    @Autowired
    private FileHelper helper;

    @Autowired
    private FileInfoRepository fileInfoRepository;

    @Override
    public FileInfo save(MultipartFile file, UserModel user) {
        FileInfo fileInfo = helper.convert(file, user);
        fileInfoRepository.save(fileInfo);
        helper.uploadFile(fileInfo, file);
        return fileInfo;
    }
}
