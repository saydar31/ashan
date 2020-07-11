package ru.itis.ashan.bl.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.ashan.entities.employer.Employer;

public interface EmployerRepository extends JpaRepository<Employer, Long> {
}
