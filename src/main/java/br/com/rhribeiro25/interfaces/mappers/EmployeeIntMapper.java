package br.com.rhribeiro25.interfaces.mappers;

import br.com.rhribeiro25.domain.models.Employee;
import br.com.rhribeiro25.domain.value_objects.Department;
import br.com.rhribeiro25.interfaces.dtos.EmployeeRequest;

public class EmployeeIntMapper {

    public Employee toDomain(EmployeeRequest employee) {
        return new Employee.Builder()
                .name(employee.name())
                .department(new Department.Builder()
                        .name(employee.name()).build())
                .role(employee.role())
                .build();
    }
}
