package br.com.rhribeiro25.application.usecases;

import br.com.rhribeiro25.application.dtos.DepartmentResponse;
import br.com.rhribeiro25.application.mappers.DepartmentAppMapper;
import br.com.rhribeiro25.domain.models.Department;
import br.com.rhribeiro25.domain.repositories.DepartmentRepository;

public class CreateDepartment {
    private final DepartmentRepository repository;
    private final DepartmentAppMapper mapper;

    public CreateDepartment(DepartmentRepository repository, DepartmentAppMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public DepartmentResponse simpleCreation(Department department) {
        return mapper.toDto(repository.save(department));
    }
}
