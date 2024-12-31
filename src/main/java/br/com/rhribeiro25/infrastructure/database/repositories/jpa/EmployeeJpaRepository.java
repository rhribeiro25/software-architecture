package br.com.rhribeiro25.infrastructure.database.repositories.jpa;

import br.com.rhribeiro25.infrastructure.database.entities.EmployeeDbEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeJpaRepository extends JpaRepository<EmployeeDbEntity, Long> {
}
