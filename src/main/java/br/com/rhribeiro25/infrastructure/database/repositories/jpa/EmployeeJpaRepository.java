package br.com.rhribeiro25.infrastructure.database.repositories.jpa;

import br.com.rhribeiro25.infrastructure.database.entities.EmployeeDbEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeJpaRepository extends JpaRepository<EmployeeDbEntity, Long> {
    Optional<EmployeeDbEntity> findByDocument(String document);
}
