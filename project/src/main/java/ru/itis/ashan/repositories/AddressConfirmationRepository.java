package ru.itis.ashan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.ashan.entities.confirmation.AddressConfirmation;

public interface AddressConfirmationRepository extends JpaRepository<AddressConfirmation, String> {
}
