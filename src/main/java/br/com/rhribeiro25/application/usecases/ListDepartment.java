package br.com.rhribeiro25.application.usecases;

import br.com.rhribeiro25.application.dtos.DepartmentResponse;
import br.com.rhribeiro25.application.mappers.DepartmentAppMapper;
import br.com.rhribeiro25.domain.repositories.DepartmentRepository;

import java.util.List;

public class ListDepartment {

    private final DepartmentRepository repository;
    private final DepartmentAppMapper mapper;

    public ListDepartment(DepartmentRepository repository, DepartmentAppMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<DepartmentResponse> getAll(){
        return mapper.toDtoList(this.repository.findAll());
    }
}
