package br.com.rhribeiro25.interfaces.mappers;

import br.com.rhribeiro25.domain.models.Employee;
import br.com.rhribeiro25.domain.models.Department;
import br.com.rhribeiro25.domain.valueobjects.CNPJ;
import br.com.rhribeiro25.interfaces.dtos.EmployeeRequest;

public class EmployeeIntMapper {

    public Employee toDomain(EmployeeRequest employee) {
        return new Employee.Builder()
                .name(employee.name())
                .role(employee.role())
                .salary(employee.salary())
                .departmentCnpj(employee.departmentCnpj())
                .build();
    }
}
