package br.com.rhribeiro25.domain.repositories;

import br.com.rhribeiro25.domain.valueobjects.Department;

public interface DepartmentRepository {
    public Department findById(String departmentId);
}
