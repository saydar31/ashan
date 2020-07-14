package ru.itis.ashan.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.ashan.entities.employer.Employer;
import ru.itis.ashan.entities.employer.EmployerDto;
import ru.itis.ashan.exceptions.UserNotFoundException;
import ru.itis.ashan.repositories.EmployerRepository;

import java.util.Optional;

@Component
public class EmployerServiceImpl implements EmployerService {
    @Autowired
    private EmployerRepository employerRepository;
    @Override
    public EmployerDto getById(Long id) {
        Optional<Employer> employerOptional = employerRepository.findById(id);
        if (employerOptional.isPresent()){
            return EmployerDto.castToDto(employerOptional.get());
        } else {
            throw new UserNotFoundException();
        }
    }
}
