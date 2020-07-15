package ru.itis.ashan.services;

import ru.itis.ashan.entities.employer.EmployerDto;

public interface EmployerService {
    EmployerDto getById(Long id);
}
