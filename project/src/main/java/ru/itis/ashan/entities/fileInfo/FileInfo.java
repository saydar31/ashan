package ru.itis.ashan.entities.fileInfo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.ashan.entities.user.UserModel;
import javax.persistence.*;
import java.time.LocalDate;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "fileInfo")
public class FileInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "storage_filename")
    private String storageFileName;

    @Transient
    private String fileName;

    @Column(name = "original_filename")
    private String originalFileName;

    @Column(name = "size")
    private Long size;

    @Column(name = "type")
    private String type;

    @Column(name = "url")
    private String url;

    @Column(name = "created_at")
    private LocalDate createdAt;

    @OneToOne
    private UserModel user;
}
