package br.com.rhribeiro25.infrastructure.file.mappers;

import br.com.rhribeiro25.domain.models.Employee;
import br.com.rhribeiro25.infrastructure.file.entities.DepartmentFileEntity;
import br.com.rhribeiro25.infrastructure.file.entities.EmployeeFileEntity;

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
                .role(employee.getRole())
                .build();
    }
}
