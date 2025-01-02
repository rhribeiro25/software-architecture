package br.com.rhribeiro25.application.usecases;

import br.com.rhribeiro25.application.dtos.EmployeeResponse;
import br.com.rhribeiro25.application.mappers.EmployeeAppMapper;
import br.com.rhribeiro25.domain.models.Department;
import br.com.rhribeiro25.domain.models.Employee;
import br.com.rhribeiro25.domain.repositories.DepartmentRepository;
import br.com.rhribeiro25.domain.repositories.EmployeeRepository;

public class CreateEmployee {
    private final EmployeeRepository employeeRepository;
    private final EmployeeAppMapper mapper;

    public CreateEmployee(EmployeeRepository employeeRepository, EmployeeAppMapper mapper) {
        this.employeeRepository = employeeRepository;
        this.mapper = mapper;
    }

    public EmployeeResponse simpleCreation(Employee employee) {
        return mapper.toDto(employeeRepository.save(employee));
    }
}
