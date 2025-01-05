package br.com.rhribeiro25.application.usecases;

import br.com.rhribeiro25.application.dtos.EmployeeResponse;
import br.com.rhribeiro25.application.mappers.EmployeeAppMapper;
import br.com.rhribeiro25.domain.models.Employee;
import br.com.rhribeiro25.domain.repositories.EmployeeRepository;

import java.util.Comparator;

public class ReadEmployeeUsingSearchAlgorithm {

    private final EmployeeRepository repository;
    private final EmployeeAppMapper mapper;
    private final SearchEmployee search;

    public ReadEmployeeUsingSearchAlgorithm(EmployeeRepository repository, EmployeeAppMapper mapper, SearchEmployee search) {
        this.repository = repository;
        this.mapper = mapper;
        this.search = search;
    }

    public EmployeeResponse read(String document) {
        Employee[] employeeList = repository.findAll().toArray(new Employee[0]);
        Comparator<Employee> comparator = Comparator.comparing(employee ->
                employee.getDocument() != null ? employee.getDocument().getValue() : ""
        );
        Employee employee = search.binarySearchEmployee(employeeList, document, comparator);
        return mapper.toDto(employee);
    }
}