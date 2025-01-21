package br.com.rhribeiro25.infrastructure.database.repositories;

import br.com.rhribeiro25.domain.models.Department;
import br.com.rhribeiro25.domain.repositories.DepartmentRepository;
import br.com.rhribeiro25.infrastructure.database.entities.DepartmentDbEntity;
import br.com.rhribeiro25.infrastructure.database.mappers.DepartmentDbMapper;
import br.com.rhribeiro25.infrastructure.database.repositories.jpa.DepartmentJpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class DepartmentDbRepository implements DepartmentRepository {
    private final DepartmentJpaRepository repository;
    private final DepartmentDbMapper mapper;

    public DepartmentDbRepository(DepartmentJpaRepository repository, DepartmentDbMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Department save(Department department) {
        DepartmentDbEntity entity = mapper.toEntity(department);
        repository.save(entity);
        return mapper.toDomain(entity);
    }

    @Override
    public Department update(Department department, Long id) {
        return null;
    }

    @Override
    public List<Department> findAll() {
        return repository.findAll().stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Department findById(Long id) {
        return null;
    }

    @Override
    public Department findByCode(String code) {
        Optional<DepartmentDbEntity> department = repository.findByCode(code);
        return mapper.toDomain(department.orElseThrow(() -> new RuntimeException("Department not found with Code: " + code)));
    }
}
