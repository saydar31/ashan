package ru.itis.ashan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.ashan.entities.admin.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}
