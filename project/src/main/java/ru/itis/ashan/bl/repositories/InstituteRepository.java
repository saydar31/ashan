package ru.itis.ashan.bl.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.ashan.entities.institute.Institute;

public interface InstituteRepository extends JpaRepository<Institute, Long> {
}
