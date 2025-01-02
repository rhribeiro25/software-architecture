package br.com.rhribeiro25.infrastructure.database.mappers;

import br.com.rhribeiro25.domain.models.Employee;
import br.com.rhribeiro25.domain.models.Department;
import br.com.rhribeiro25.infrastructure.database.entities.DepartmentDbEntity;
import br.com.rhribeiro25.infrastructure.database.entities.EmployeeDbEntity;

public class EmployeeDbMapper {

    public EmployeeDbEntity toEntity(Employee employee) {
        return new EmployeeDbEntity.Builder()
                .name(employee.getName())
                .role(employee.getRole())
                .salary(employee.getSalary())
                .department(new DepartmentDbEntity.Builder()
                        .cnpj(employee.getDepartmentCnpj()).build())
                .build();
    }

    public Employee toDomain(EmployeeDbEntity employee) {
        return new Employee.Builder()
                .name(employee.getName())
                .departmentCnpj(employee.getDepartment().getCnpj())
                .role(employee.getRole())
                .build();
    }
}
