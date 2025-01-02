package br.com.rhribeiro25.infrastructure.database.repositories.jpa;

import br.com.rhribeiro25.infrastructure.database.entities.DepartmentDbEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DepartmentJpaRepository extends JpaRepository<DepartmentDbEntity, Long> {
    Optional<DepartmentDbEntity> findByCnpj(String cnpj);

}
