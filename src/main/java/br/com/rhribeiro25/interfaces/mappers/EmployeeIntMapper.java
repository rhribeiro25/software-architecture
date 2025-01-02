package br.com.rhribeiro25.interfaces.mappers;

import br.com.rhribeiro25.domain.models.Employee;
import br.com.rhribeiro25.interfaces.dtos.EmployeeRequest;

public class EmployeeIntMapper {

    public Employee toDomain(EmployeeRequest employee) {
        return new Employee.Builder()
                .name(employee.name())
                .role(employee.role())
                .salary(employee.salary())
                .departmentCode(employee.departmentCode())
                .build();
    }
}
