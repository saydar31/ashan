package ru.itis.ashan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.ashan.entities.fileInfo.FileInfo;

public interface FileInfoRepository extends JpaRepository<FileInfo, Long> {
}
