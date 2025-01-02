package br.com.rhribeiro25.infrastructure.database.mappers;

import br.com.rhribeiro25.domain.models.Department;
import br.com.rhribeiro25.domain.valueobjects.CNPJ;
import br.com.rhribeiro25.infrastructure.database.entities.DepartmentDbEntity;

public class DepartmentDbMapper {

    public DepartmentDbEntity toEntity(Department department) {
        return new DepartmentDbEntity.Builder()
                .cnpj(department.getCnpj().getValue())
                .name(department.getName())
                .build();
    }

    public Department toDomain(DepartmentDbEntity department) {
        return new Department.Builder()
                .cnpj(new CNPJ.Builder().value(department.getCnpj()).build())
                .name(department.getName())
                .build();
    }
}
