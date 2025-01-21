package br.com.rhribeiro25.application.usecases;

import br.com.rhribeiro25.application.dtos.EmployeeResponse;
import br.com.rhribeiro25.application.mappers.EmployeeAppMapper;
import br.com.rhribeiro25.domain.repositories.EmployeeRepository;

public class FindEmployeeByDocument {

    private final EmployeeRepository repository;
    private final EmployeeAppMapper mapper;

    public FindEmployeeByDocument(EmployeeRepository repository, EmployeeAppMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public EmployeeResponse getByDocument(String document){
        return mapper.toDto(this.repository.findByDocument(document));
    }
}
