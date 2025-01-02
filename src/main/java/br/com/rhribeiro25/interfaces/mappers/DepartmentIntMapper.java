package br.com.rhribeiro25.interfaces.mappers;

import br.com.rhribeiro25.domain.models.Department;
import br.com.rhribeiro25.domain.valueobjects.CNPJ;
import br.com.rhribeiro25.interfaces.dtos.DepartmentRequest;

public class DepartmentIntMapper {

    public Department toDomain(DepartmentRequest department) {
        return new Department.Builder()
                .cnpj(new CNPJ.Builder().value(department.getCnpj()).build())
                .name(department.getName())
                .build();
    }
}
