package br.com.rhribeiro25.application.usecases;

import br.com.rhribeiro25.application.dtos.EmployeeResponse;
import br.com.rhribeiro25.application.mappers.EmployeeAppMapper;
import br.com.rhribeiro25.domain.repositories.EmployeeRepository;
import br.com.rhribeiro25.domain.models.Employee;
import br.com.rhribeiro25.shared.mocks.RandomEmployeeList;

import java.util.List;

public class WriteRandomMockEmployee {

    private final EmployeeRepository repository;
    private final EmployeeAppMapper mapper;

    public WriteRandomMockEmployee(EmployeeRepository repository, EmployeeAppMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<EmployeeResponse> writeRandomly() {
        List<Employee> randomList = RandomEmployeeList.create();
        List<Employee> employeeListSaved = randomList.stream().map(repository::save).toList();;
        return mapper.toDtoList(employeeListSaved);
    }

}