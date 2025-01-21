package br.com.rhribeiro25.application.mappers;

import br.com.rhribeiro25.application.dtos.DepartmentResponse;
import br.com.rhribeiro25.domain.models.Department;

import java.util.List;
import java.util.stream.Collectors;

public class DepartmentAppMapper {
    public DepartmentResponse toDto(Department department) {
        return new DepartmentResponse.Builder()
                .code(department.getCode().getValue())
                .build();
    }

    public List<DepartmentResponse> toDtoList(List<Department> departments) {
        return departments.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
