package br.com.rhribeiro25.application.usecases;

import br.com.rhribeiro25.application.dtos.EmployeeResponse;
import br.com.rhribeiro25.application.mappers.EmployeeAppMapper;
import br.com.rhribeiro25.domain.repositories.EmployeeRepository;

import java.util.List;

public class ReadEmployee {

    private final EmployeeRepository repository;
    private final EmployeeAppMapper mapper;

    public ReadEmployee(EmployeeRepository repository, EmployeeAppMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<EmployeeResponse> readAll() {
        return mapper.toDtoList(repository.findAll());
    }
}