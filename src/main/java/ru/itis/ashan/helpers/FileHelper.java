package ru.itis.ashan.helpers;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import ru.itis.ashan.entities.fileInfo.FileInfo;
import ru.itis.ashan.entities.user.UserDto;
import ru.itis.ashan.entities.user.UserModel;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.UUID;

@Component
public class FileHelper {

    @Value("${storage.files}")
    private String path;

    public FileInfo convert(MultipartFile file, UserDto user) {
        String fileName = createStorageName(file);
        return FileInfo.builder()
                .originalFileName(file.getOriginalFilename())
                .storageFileName(fileName)
                .size(file.getSize())
                .type(file.getContentType())
                .createdAt(LocalDate.now())
                .build();
    }

    public FileInfo convert(MultipartFile file) {
        String fileName = createStorageName(file);
        return FileInfo.builder()
                .originalFileName(file.getOriginalFilename())
                .storageFileName(fileName)
                .size(file.getSize())
                .type(file.getContentType())
                .createdAt(LocalDate.now())
                .build();
    }

    private String createStorageName(MultipartFile file) {
        return UUID.randomUUID().toString() + "." +
                FilenameUtils.getExtension(file.getOriginalFilename()) ;
    }

    public void uploadFile(FileInfo fileInfo, MultipartFile file) {
        try {
            //берем абсолютный путь до папки:
            String pathDir = path;
            File dir = new File(pathDir);
            //проверяем, существует ли такая папка
            if (!dir.exists()) {
                dir.mkdir();
            }
            String fullPath = pathDir + File.separator + fileInfo.getStorageFileName();
            byte[] bytes = file.getBytes();
            BufferedOutputStream stream =
                    new BufferedOutputStream(new FileOutputStream(new File(fullPath)));
            stream.write(bytes);
            stream.close();
        } catch (IOException e) {
            throw new IllegalArgumentException();
        }
    }

    public File downloadFile(FileInfo fileInfo){
        return new File(path + fileInfo.getStorageFileName());
    }
}

