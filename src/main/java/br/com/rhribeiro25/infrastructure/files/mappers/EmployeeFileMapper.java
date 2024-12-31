package br.com.rhribeiro25.infrastructure.files.mappers;

import br.com.rhribeiro25.domain.models.Employee;
import br.com.rhribeiro25.domain.value_objects.Department;
import br.com.rhribeiro25.infrastructure.files.entities.DepartmentFileEntity;
import br.com.rhribeiro25.infrastructure.files.entities.EmployeeFileEntity;

public class EmployeeFileMapper {

    public EmployeeFileEntity toEntity(Employee employee) {
        return new EmployeeFileEntity.Builder()
                .name(employee.getName())
                .department(new DepartmentFileEntity.Builder()
                        .name(employee.getName()).build())
                .role(employee.getRole())
                .build();
    }

    public Employee toDomain(EmployeeFileEntity employee) {
        return new Employee.Builder()
                .name(employee.getName())
                .department(new Department.Builder()
                        .name(employee.getName()).build())
                .role(employee.getRole())
                .build();
    }
}
