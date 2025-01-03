package br.com.rhribeiro25.application.usecases;

import br.com.rhribeiro25.application.dtos.EmployeeResponse;
import br.com.rhribeiro25.application.mappers.EmployeeAppMapper;
import br.com.rhribeiro25.domain.models.Employee;
import br.com.rhribeiro25.domain.repositories.EmployeeRepository;

import java.util.Arrays;
import java.util.List;

public class ReadEmployee {

    private final EmployeeRepository repository;
    private final EmployeeAppMapper mapper;
    private final SortedEmployee sorted;

    public ReadEmployee(EmployeeRepository repository, EmployeeAppMapper mapper, SortedEmployee sorted) {
        this.repository = repository;
        this.mapper = mapper;
        this.sorted = sorted;
    }

    public List<EmployeeResponse> readAll() {
        Employee[] employeeListSorted = sorted.mergeSort(repository.findAll().toArray(new Employee[0]));
        return mapper.toDtoList(Arrays.stream(employeeListSorted).toList());
    }
}