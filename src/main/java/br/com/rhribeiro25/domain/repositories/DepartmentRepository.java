package br.com.rhribeiro25.domain.repositories;

import br.com.rhribeiro25.domain.models.Department;

import java.util.List;

// Strategy Design Pattern flexibility to update, reusability across contexts,
// and scalability for complex cases with new strategies.

public interface DepartmentRepository {
    List<Department> findAll();

    Department findById(Long id);

    Department findByCode(String code);

    Department save(Department department);

    Department update(Department department, Long id);
}
