package br.com.rhribeiro25.infrastructure.messaging.mappers;

import br.com.rhribeiro25.domain.models.Employee;
import br.com.rhribeiro25.domain.value_objects.Department;
import br.com.rhribeiro25.infrastructure.messaging.entities.DepartmentMsgEntity;
import br.com.rhribeiro25.infrastructure.messaging.entities.EmployeeMsgEntity;

public class EmployeeMsgMapper {

    public EmployeeMsgEntity toEntity(Employee employee) {
        return new EmployeeMsgEntity.Builder()
                .name(employee.getName())
                .department(new DepartmentMsgEntity.Builder()
                        .name(employee.getName()).build())
                .role(employee.getRole())
                .build();
    }

    public Employee toDomain(EmployeeMsgEntity employee) {
        return new Employee.Builder()
                .name(employee.getName())
                .department(new Department.Builder()
                        .name(employee.getName()).build())
                .role(employee.getRole())
                .build();
    }
}
