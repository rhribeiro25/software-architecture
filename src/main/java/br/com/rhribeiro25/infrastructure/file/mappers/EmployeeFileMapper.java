package br.com.rhribeiro25.infrastructure.file.mappers;

import br.com.rhribeiro25.application.dtos.EmployeeResponse;
import br.com.rhribeiro25.domain.models.Employee;
import br.com.rhribeiro25.domain.valueobjects.employee.Document;
import br.com.rhribeiro25.infrastructure.file.entities.DepartmentFileEntity;
import br.com.rhribeiro25.infrastructure.file.entities.EmployeeFileEntity;
import br.com.rhribeiro25.shared.enums.DepartmentCodeEnum;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class EmployeeFileMapper {

    public EmployeeFileEntity toEntity(Long id, Employee employee) {
        return new EmployeeFileEntity.Builder()
                .id(id)
                .name(employee.getName())
                .documentType(Optional.ofNullable(employee.getDocument())
                        .map(Document::getType)
                        .orElse(null))
                .document(Optional.ofNullable(employee.getDocument())
                        .map(Document::getValue)
                        .orElse(null))
                .role(employee.getRole())
                .salary(employee.getSalary())
                .department(new DepartmentFileEntity.Builder()
                        .id(DepartmentCodeEnum.valueOf(employee.getDepartmentCode()).getKey())
                        .name(DepartmentCodeEnum.valueOf(employee.getDepartmentCode()).getDescription())
                        .code(employee.getDepartmentCode())
                        .build())
                .build();
    }

    public Employee toDomain(EmployeeFileEntity employee) {
        return new Employee.Builder()
                .name(employee.getName())
                .document(new Document.Builder().type(employee.getDocumentType()).value(employee.getDocument()).build())
                .role(employee.getRole())
                .salary(employee.getSalary())
                .departmentCode(employee.getDepartment().getCode())
                .build();
    }

    public List<Employee> toDomainList(List<EmployeeFileEntity> employees) {
        return employees.stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }
}
