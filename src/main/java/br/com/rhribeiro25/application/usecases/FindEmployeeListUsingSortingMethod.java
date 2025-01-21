package br.com.rhribeiro25.application.usecases;

import br.com.rhribeiro25.application.dtos.EmployeeResponse;
import br.com.rhribeiro25.application.mappers.EmployeeAppMapper;
import br.com.rhribeiro25.domain.models.Employee;
import br.com.rhribeiro25.domain.repositories.EmployeeRepository;

import java.util.Comparator;
import java.util.List;

public class FindEmployeeListUsingSortingMethod {

    private final EmployeeRepository repository;
    private final EmployeeAppMapper mapper;

    public FindEmployeeListUsingSortingMethod(EmployeeRepository repository, EmployeeAppMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<EmployeeResponse> getAll(){
        List<Employee> employeeListSorted = this.repository.findAll().stream()
                .sorted(Comparator.comparing(Employee::getName)).toList();
        return mapper.toDtoList(employeeListSorted);
    }
}
