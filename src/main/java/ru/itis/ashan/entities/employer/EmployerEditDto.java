package ru.itis.ashan.entities.employer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployerEditDto {
    private String companyName;
    private String phoneNumber;

    private MultipartFile image;
}
