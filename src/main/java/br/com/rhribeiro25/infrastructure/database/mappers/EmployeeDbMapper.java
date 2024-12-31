package br.com.rhribeiro25.infrastructure.database.mappers;

import br.com.rhribeiro25.domain.models.Employee;
import br.com.rhribeiro25.domain.valueobjects.Department;
import br.com.rhribeiro25.infrastructure.database.entities.DepartmentDbEntity;
import br.com.rhribeiro25.infrastructure.database.entities.EmployeeDbEntity;

public class EmployeeDbMapper {

    public EmployeeDbEntity toEntity(Employee employee) {
        return new EmployeeDbEntity.Builder()
                .name(employee.getName())
                        .department(new DepartmentDbEntity.Builder()
                                .name(employee.getName()).build())
                                .role(employee.getRole())
                .build();
    }

    public Employee toDomain(EmployeeDbEntity employee) {
        return new Employee.Builder()
                .name(employee.getName())
                .department(new Department.Builder()
                        .name(employee.getName()).build())
                .role(employee.getRole())
                .build();
    }
}
