package br.com.rhribeiro25.application.usecases;

import br.com.rhribeiro25.application.dtos.EmployeeResponse;
import br.com.rhribeiro25.application.mappers.EmployeeAppMapper;
import br.com.rhribeiro25.domain.repositories.EmployeeRepository;
import br.com.rhribeiro25.domain.models.Employee;
import br.com.rhribeiro25.domain.services.EmployeeService;

import java.util.List;

public class WriteRandomMockEmployee {

    private final EmployeeRepository repository;
    private final EmployeeAppMapper mapper;
    private final EmployeeService employeeService;

    public WriteRandomMockEmployee(EmployeeRepository repository, EmployeeService employeeService, EmployeeAppMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
        this.employeeService = employeeService;
    }

    public List<EmployeeResponse> writeRandomly() {
        List<Employee> randomList = employeeService.createRandomMockList();
        List<Employee> employeeListSaved = randomList.stream().map(repository::save).toList();;
        return mapper.toDtoList(employeeListSaved);
    }

}