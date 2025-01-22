package br.com.rhribeiro25.domain.repositories;

import br.com.rhribeiro25.domain.models.department.Department;

import java.util.List;

// STRATEGY PATTERN offers flexibility to update, reusability across contexts,
// and scalability for complex cases with new strategies.

public interface DepartmentRepository {
    List<Department> findAll();

    Department findById(Long id);

    Department findByCode(String code);

    Department save(Department department);

    Department update(Department department, Long id);
}
