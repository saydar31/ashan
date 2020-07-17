package ru.itis.ashan.entities.employer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployerEditDto {
    private String companyName;
    private String phoneNumber;
}
