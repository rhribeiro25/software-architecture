package br.com.rhribeiro25.interfaces.mappers;

import br.com.rhribeiro25.domain.models.Employee;
import br.com.rhribeiro25.domain.valueobjects.employee.Document;
import br.com.rhribeiro25.interfaces.dtos.EmployeeRequest;

public class EmployeeIntMapper {

    public Employee toDomain(EmployeeRequest employee) {
        return new Employee.Builder()
                .document(new Document.Builder().type(employee.documentType()).value(employee.document()).build())
                .name(employee.name())
                .role(employee.role())
                .salary(employee.salary())
                .departmentCode(employee.departmentCode())
                .build();
    }
}
