package br.com.rhribeiro25.application.mappers;

import br.com.rhribeiro25.application.dtos.DepartmentResponse;
import br.com.rhribeiro25.application.dtos.EmployeeResponse;
import br.com.rhribeiro25.domain.models.Employee;

import java.util.List;
import java.util.stream.Collectors;

public class EmployeeAppMapper {

    public EmployeeResponse toDto(Employee employee) {
        return new EmployeeResponse.Builder()
                .name(employee.getName())
                .role(employee.getRole())
                .departmentCode(employee.getDepartmentCode())
                .build();
    }

    public List<EmployeeResponse> toDtoList(List<Employee> employees) {
        return employees.stream()
                .map(this::toDto)
            .collect(Collectors.toList());
    }

}
