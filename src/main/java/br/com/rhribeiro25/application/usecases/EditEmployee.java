package br.com.rhribeiro25.application.usecases;

import br.com.rhribeiro25.application.dtos.EmployeeResponse;
import br.com.rhribeiro25.application.mappers.EmployeeAppMapper;
import br.com.rhribeiro25.domain.models.Employee;
import br.com.rhribeiro25.domain.repositories.EmployeeRepository;

public class EditEmployee {
    private final EmployeeRepository employeeRepository;
    private final EmployeeAppMapper mapper;

    public EditEmployee(EmployeeRepository employeeRepository, EmployeeAppMapper mapper) {
        this.employeeRepository = employeeRepository;
        this.mapper = mapper;
    }

    public EmployeeResponse updateLine(Employee employee) {
        return mapper.toDto(employeeRepository.update(employee));
    }

}
