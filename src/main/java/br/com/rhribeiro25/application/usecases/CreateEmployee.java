package br.com.rhribeiro25.application.usecases;

import br.com.rhribeiro25.application.dtos.EmployeeResponse;
import br.com.rhribeiro25.application.mappers.EmployeeAppMapper;
import br.com.rhribeiro25.domain.models.Employee;
import br.com.rhribeiro25.domain.repositories.EmployeeRepository;

public class CreateEmployee {
    private final EmployeeRepository repository;
    private final EmployeeAppMapper mapper;

    public CreateEmployee(EmployeeRepository repository, EmployeeAppMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public EmployeeResponse create(Employee employee) {
        return mapper.toDto(repository.save(employee));
    }
}
