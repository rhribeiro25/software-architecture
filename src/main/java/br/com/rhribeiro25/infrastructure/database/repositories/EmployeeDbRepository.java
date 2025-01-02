package br.com.rhribeiro25.infrastructure.database.repositories;

import br.com.rhribeiro25.domain.models.Employee;
import br.com.rhribeiro25.domain.repositories.EmployeeRepository;
import br.com.rhribeiro25.infrastructure.database.entities.DepartmentDbEntity;
import br.com.rhribeiro25.infrastructure.database.entities.EmployeeDbEntity;
import br.com.rhribeiro25.infrastructure.database.mappers.EmployeeDbMapper;
import br.com.rhribeiro25.infrastructure.database.repositories.jpa.DepartmentJpaRepository;
import br.com.rhribeiro25.infrastructure.database.repositories.jpa.EmployeeJpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class EmployeeDbRepository implements EmployeeRepository {
    private final EmployeeJpaRepository employeeJpaRepository;
    private final DepartmentJpaRepository departmentJpaRepository;
    private final EmployeeDbMapper mapper;

    public EmployeeDbRepository(EmployeeJpaRepository employeeJpaRepository, DepartmentJpaRepository departmentJpaRepository, EmployeeDbMapper mapper) {
        this.employeeJpaRepository = employeeJpaRepository;
        this.departmentJpaRepository = departmentJpaRepository;
        this.mapper = mapper;
    }

    @Override
    public Employee save(Employee employee) {
        Optional<DepartmentDbEntity> department = departmentJpaRepository.findByCode(employee.getDepartmentCode());
        EmployeeDbEntity entity = mapper.toEntity(employee);
        entity.setDepartment(department.orElseThrow(() -> new RuntimeException("Department not found with DepartmentCode: " + employee.getDepartmentCode())));
        employeeJpaRepository.save(entity);
        return mapper.toDomain(entity);
    }

    @Override
    public Employee update(Employee employee, Long id) {
        return null;
    }

    @Override
    public List<Employee> findAll() {
        return employeeJpaRepository.findAll().stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Employee findById(Long id) {
        return null;
    }

}
