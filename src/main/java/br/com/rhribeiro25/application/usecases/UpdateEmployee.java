package br.com.rhribeiro25.application.usecases;

import br.com.rhribeiro25.application.dtos.EmployeeResponse;
import br.com.rhribeiro25.application.mappers.EmployeeAppMapper;
import br.com.rhribeiro25.domain.models.employee.Employee;
import br.com.rhribeiro25.domain.repositories.EmployeeRepository;

public class UpdateEmployee {
    private final EmployeeRepository employeeRepository;
    private final EmployeeAppMapper mapper;

    public UpdateEmployee(EmployeeRepository employeeRepository, EmployeeAppMapper mapper) {
        this.employeeRepository = employeeRepository;
        this.mapper = mapper;
    }

    public EmployeeResponse fullUpdate(Employee employee) {
        return mapper.toDto(employeeRepository.update(employee));
    }

}
