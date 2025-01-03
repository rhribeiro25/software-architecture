package br.com.rhribeiro25.application.usecases;

import br.com.rhribeiro25.application.dtos.EmployeeResponse;
import br.com.rhribeiro25.application.mappers.EmployeeAppMapper;
import br.com.rhribeiro25.domain.repositories.EmployeeRepository;
import br.com.rhribeiro25.domain.models.Employee;

public class WriteEmployee {

    private final EmployeeRepository employeeRepository;
    private final EmployeeAppMapper mapper;

    public WriteEmployee(EmployeeRepository employeeRepository, EmployeeAppMapper mapper) {
        this.employeeRepository = employeeRepository;
        this.mapper = mapper;
    }

    public EmployeeResponse simpleWrite(Employee employee) {
        return mapper.toDto(employeeRepository.save(employee));
    }
}