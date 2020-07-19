package ru.itis.ashan.services;

import ru.itis.ashan.entities.employer.Employer;
import ru.itis.ashan.entities.employer.EmployerDto;
import ru.itis.ashan.entities.employer.EmployerEditDto;
import ru.itis.ashan.entities.fileInfo.FileInfo;

public interface EmployerService {
    EmployerDto getById(Long id);
    void edit(Employer employer, EmployerEditDto employerEditDto, FileInfo fileInfo);
}
