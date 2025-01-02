package br.com.rhribeiro25.interfaces.mappers;

import br.com.rhribeiro25.domain.models.Department;
import br.com.rhribeiro25.domain.valueobjects.DepartmentCode;
import br.com.rhribeiro25.interfaces.dtos.DepartmentRequest;

public class DepartmentIntMapper {

    public Department toDomain(DepartmentRequest department) {
        return new Department.Builder()
                .code(new DepartmentCode.Builder().value(department.getCode()).build())
                .name(department.getName())
                .build();
    }
}
