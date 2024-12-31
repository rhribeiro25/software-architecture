package br.com.rhribeiro25.infrastructure.database.repositories;

import br.com.rhribeiro25.domain.models.Employee;
import br.com.rhribeiro25.domain.repositories.EmployeeRepository;
import br.com.rhribeiro25.infrastructure.database.entities.EmployeeDbEntity;
import br.com.rhribeiro25.infrastructure.database.mappers.EmployeeDbMapper;

import java.util.List;
import java.util.stream.Collectors;

public class EmployeeDbRepository implements EmployeeRepository {
    private final EmployeeJpaRepository repository;
    private final EmployeeDbMapper mapper;

    public EmployeeDbRepository(EmployeeJpaRepository repository, EmployeeDbMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Employee save(Employee employee) {
        EmployeeDbEntity entity = mapper.toEntity(employee);
        repository.save(entity);
        return mapper.toDomain(entity);
    }

    @Override
    public Employee update(Employee employee, Long id) {
        return null;
    }

    @Override
    public List<Employee> findAll() {
        return repository.findAll().stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Employee findById(Long id) {
        return null;
    }
}
