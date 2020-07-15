package ru.itis.ashan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.itis.ashan.entities.employer.Employer;

import java.util.List;

public interface EmployerRepository extends JpaRepository<Employer, Long> {

    @Query("SELECT e FROM Employer e WHERE e.state='NOT_CONFIRMED'")
    List<Employer> findAllNotConfirmed();
}
